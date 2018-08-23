#include<bits/stdc++.h>
using namespace std;
int main()
{
	int n,i,j,b[10],temp[10],index[10],t=0,w[10];
	float total=0.0f;
	cout<<"Enter the number of process : ";
	cin>>n;
	
	for(i=0;i<n;i++)
	{
			cout<<"Enter the burst time of process "<<i+1<<" : ";
			cin>>b[i];
			temp[i]=b[i];
	}
	
	sort(b,b+n);
	for(i=0;i<n;i++)
	{
			for(j=0;j<n;j++)
			{
				if(b[i]==temp[j])
				{
					index[i]=j;
				}	
			}
	}
		for(i=0;i<n;i++)
	{
			w[index[i]]=t;
			t+=b[i];
			total+=w[index[i]];
		}
	//cout<<"\n\tProcess \t     Waiting time\n";
		//	cout<<"\t   "<<i+1<<"\t\t\t "<<w[i]<<endl;
	cout<<"\n\nTotal waiting time   : "<<total<<endl;
	cout<<"\nAverage Waiting time : "<<total/n;
	return 0;
}

