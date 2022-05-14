package buddy2;

import java.util.LinkedList;

public class allList {
LinkedList<llist> alllist=null;//二维链表

LinkedList<node>nodelist=null;
LinkedList<node>savelist=null;//存储已分配空间
allList()
{alllist=new LinkedList<llist> ();
nodelist=new LinkedList<node>();
savelist=new LinkedList<node>();
for(int i=0;i<10;i++)
{
	llist ll=new llist((int) Math.pow(2,9-i),0);
	alllist.addLast(ll);
}
alllist.get(0).list=new LinkedList<node>();
for(int i=0;i<10;i++)
{
alllist.get(0).list.add(new node(512,-1,i*512));
}
}
public int FindnotNull(int p)
{
	int pp=                                                                                                                                                                                                                                           0;
	this.nodelist=alllist.get(p).list;
	if(nodelist.size()==0) {
		return FindnotNull(p-1);
	}
	else {pp=p;return pp;}
}
public void add(int usespace) {
	if(usespace>512)
	{
		System.out.println("超出范围");
	}
	else {
		node node = new node(0,usespace,0);
		int p = 0;
		for(int i=0; i<10;i++)
    	{
    		if(usespace<Math.pow(2, 8-i)) {continue;}
    		else {p=i;break;}
    	}
		node.space=(int) Math.pow(2, 9-p);
		nodelist=alllist.get(p).list;
		if(nodelist.size()==0)
		{
			int NearestBlankNodeList=FindnotNull(p);
			nodelist=alllist.get(NearestBlankNodeList).list;
			int NBstart=nodelist.getLast().startpoint;
			int NBspace=nodelist.getLast().space;
			alllist.get(NearestBlankNodeList).list.removeLast();
			int pspace=NBspace/2;
			int pstart=NBstart;
			alllist.get(NearestBlankNodeList+1).list.add(new node(pspace,0,pstart));
			for(int i=NearestBlankNodeList+2;i<=p;i++)
			{
				pstart=pstart+pspace;
				pspace=pspace/2;
				alllist.get(i).list.add(new node(pspace,0,pstart));
				alllist.get(i).knumber++;
			}
			node.startpoint=pstart+pspace;
			node.setState();
			savelist.add(node);
		}
		else {
			int startp=alllist.get(p).list.getLast().startpoint;
			alllist.get(p).list.removeLast();
			node.startpoint=startp;
			node.setState();
			savelist.add(node);
		} 
	}  
}
public static void main(String []args) 
{
	allList buddytest=new allList();
	int i= buddytest.alllist.get(0).list.get(1).startpoint;
	System.out.println(i);
}
}
