package m03.d28.chenyang;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BaseDao
 * @Description TODO(数据库工具类)
 * @author wzciou
 * @Date 2017年12月22日 下午5:17:00
 * @version 2.0.0
 */
public class BaseDao {

    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;

    /**
     * @Description (查询并返回Map List集合)
     * @param sql
     * @return
     */
    public List<Map<String, Object>> executeQueryMapList(String sql, Object... params) {
        rs = this.executeQuery(sql, params);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        try {
            // 元数据
            ResultSetMetaData metaData = rs.getMetaData();

            // 列数
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i);
                    Object columnValue = rs.getObject(i);
                    map.put(columnLabel, columnValue);
                }

                mapList.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapList;
    }

    /**
     * @Description (查询并返回单个对象)
     * @param clazz
     * @param sql
     * @param params
     * @return
     */
    protected <T> T executeQueryOne(Class<T> clazz, String sql, Object... params) {
        List<T> list = this.executeQueryList(clazz, sql, params);
        if (list != null && list.size() != 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * @param <T>
     * @Description (查询并返回对象集合)
     * @param sql
     * @param params
     * @return
     */
    protected <T> List<T> executeQueryList(Class<T> clazz, String sql, Object... params) {
        rs = this.executeQuery(sql, params);

        List<T> list = new ArrayList<T>();
        try {
            // 元数据
            ResultSetMetaData metaData = rs.getMetaData();

            // 列数
            int columnCount = metaData.getColumnCount();
            // 通过列号得到列名,列号从1开始
            // String columnName = metaData.getColumnName(1);

            Field[] fields = clazz.getDeclaredFields();

            while (rs.next()) {
                T newInstance = clazz.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    for (Field field : fields) {
                        Object columnValue = rs.getObject(i);
                        if (columnValue == null) {
                            break;
                        }
                        String columnName = metaData.getColumnLabel(i);
                        String fieldName = field.getName();

                        // System.out.println(fieldName+"\t"+columnName+"\t"+columnValue);
                        if (fieldName.equalsIgnoreCase(columnName.replaceAll("[-_]", ""))) {
                            field.setAccessible(true);
                            field.set(newInstance, columnValue);
                            field.setAccessible(false);
                        }
                    }
                }
                list.add(newInstance);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnertion();
        }
        return null;
    }

    /**
     * @Description (查询)
     * @param sql
     * @param params
     * @return
     */
    protected ResultSet executeQuery(String sql, Object... params) {
        conn = this.getConnection();
        try {
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description (通过JdbcUtil创建连接)
     * @return
     */
    protected Connection getConnection() {
        conn = JdbcUtil.getConnection();
        return conn;
    }

    /**
     * @Description (增删改)
     * @param sql
     * @param params
     * @return
     */
    protected int executeUpdate(String sql, Object... params) {
        conn = this.getConnection();
        try {
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            int count = ps.executeUpdate();
            return count;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnertion();
        }
        return 0;
    }

    protected void closeConnertion() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            // 如果当前autoCommit为true说明当前操作是没有开启事务的,所以可以关闭当前连接
            // 如果当前autoCommit为false,conn由JdbcUtil的closeConnection()方法来关
            boolean autoCommit = conn.getAutoCommit();
            if (autoCommit) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // System.out.println(conn);
    }
}
