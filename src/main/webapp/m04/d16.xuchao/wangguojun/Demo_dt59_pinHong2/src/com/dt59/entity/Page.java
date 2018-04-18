package com.dt59.entity;

public class Page {
	private int currentpage;//��ǰҳ
	private int pagesize=3;//ÿҳ��ʾ����
	private int sumsize;//������
	private int lastpage;//βҳ
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		if(currentpage<=0){
			this.currentpage=1;
		}else{
			if(currentpage>this.lastpage){
				this.currentpage=this.lastpage;
			}else{
				this.currentpage = currentpage;
			}
		}
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getSumsize() {
		return sumsize;
	}
	public void setSumsize(int sumsize) {
		this.sumsize = sumsize;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	
}
