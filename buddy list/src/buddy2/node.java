package buddy2;

public class node {
int space;
int usespace;
int startpoint;
static int countNumber=0;
int state;
node(int s,int us,int st)
{
space=s;
usespace=us;
startpoint=st;
state=-1;
}
void setState()
{
	countNumber++;
	state=countNumber;
}
}
