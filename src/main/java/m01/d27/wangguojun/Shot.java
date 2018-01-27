/**
 * Project Name:snail
 * File Name:shot.java
 * Package Name:m01.d25.wangguojun
 * Date:2018年1月27日下午4:55:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d25.wangguojun;
/**
 * Description:   <br/>
 * Date:     2018年1月27日 下午4:55:29 <br/>
 * @author   wangguojun
 * @version
 * @see
 */

    /**
     * @see 子弹类  线程 
     * */
    public class Shot implements Runnable{
        private int x;
        private int y;
        private int direct;//方向
        private int speed=3;
        private boolean isLive=true;//是否活着在
        public Shot(){}
        public Shot(int x,int y,int direct){
            this.x=x;
            this.y=y;
            this.direct=direct;
        }
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getDirect() {
            return direct;
        }
        public void setDirect(int direct) {
            this.direct = direct;
        }
        public int getSpeed() {
            return speed;
        }
        public void setSpeed(int speed) {
            this.speed = speed;
        }
        public boolean isLive() {
            return isLive;
        }
        public void setLive(boolean isLive) {
            this.isLive = isLive;
        }
        @Override
        public void run() {

            while(true){
                try {
                    // 炮筒的方向决定子弹发射的方向
                    switch(this.direct){

                        case 0:
                        // 向上
                            this.y-=this.speed;
                    break;
                        case 1:
                            //向右
                            this.x+=this.speed;
                            break;
                        case 2:
                            //向下
                            this.y+=this.speed;
                            break;
                        case 3:
                            //向左
                            this.x-=this.speed;
                            break;
                    }
                    Thread.sleep(50);
                } catch (Exception e) {

                    e.printStackTrace();
                }

            if (this.x < 0 || this.x > 400 || this.y < 0 || this.y > 300) {
                    this.isLive=false;
                    break;
                }
            }
        }
    }





