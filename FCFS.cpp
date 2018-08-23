#include<iostream>
using namespace std;
int main()
{
	int i,b[10],n;
	float total=0,w=0;
	cout<<"Enter number of processes: ";
	cin>>n;
	for(i=1;i<=n;i++)
	{
		cout<<"Burst time of "<<i<<" process: ";
		cin>>b[i];
	}
	
	cout<<"\n\tProcess \t     Waiting time  \t   turn around time\n";
	for(i=1;i<=n;i++)
	{	
		total+=w;
		cout<<"Process "<<i<<"\t\t\t "<<w<<endl;
		w+=b[i];
	}
	cout<<"\n\nTotal waiting time   : "<<total<<endl;
	cout<<"Average waiting time : "<<total/n<<endl;
	return 0;
}

