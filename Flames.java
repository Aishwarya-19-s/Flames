import java.util.*;
public class Flames{
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Ur Name:");
		String name=in.next();
		System.out.println("Enter Ur Partner's Name:");
		String p_name=in.next();
		FlamesGame f=new FlamesGame(name,p_name);
		int count=f.countChar();
		String rel=f.findFlames(count);
		switch(rel)
		{
			case "F":
			{
				rel="FRIEND 🤩";
				break;
			}
			case "L":
			{
				rel="LOVE 💖";
				break;
			}
			case "A":
			{
				rel="AFFECTION 😘";
				break;
			}
			case "M":
			{
				rel="MARRIAGE 😍";
				break;
			}
			case "E":
			{
				rel="ENEMY 😖";
				break;
			}
			default:
			{
				rel="SISTER 😊😊";
			}
			
		}
		System.out.println("The Relationship between U"+name+" and Ur Partner "+p_name+" is "+rel);
		
	}
	
}
class FlamesGame{
	private String name;
	private String par_name;
	public FlamesGame(String name,String p_name){
		this.name=name;
		this.par_name=p_name;
	}
	public int countChar()
	{
		int count=0;
		int[] freq1=new int[256];
		int[] freq2=new int[256];
		String nam=this.name.toLowerCase();
		String p_name=this.par_name.toLowerCase();
		for(int i=0;i<nam.length();i++)
		{
			int ind=(int)nam.charAt(i);
			freq1[ind]++;
		}
		for(int i=0;i<p_name.length();i++)
		{
			int ind=(int)p_name.charAt(i);
			freq2[ind]++;
		}
		for(int i=0;i<256;i++){
			if(Math.abs(freq1[i]-freq2[i])!=0)
			{
				count+=Math.abs(freq1[i]-freq2[i]);
			}
		}
		return count;
	}
	public String findFlames(int c)
	{
		String res="FLAMES";
		
		do{
			int len=res.length();
			int ind=(c-1)%len;
			if(ind==len-1){
			res=res.substring(0,ind)+res.substring(ind+1,len);}
			else{
				res=res.substring(ind+1,len)+res.substring(0,ind);
			}
		}while(res.length()!=1);
		return res;
	}
}
