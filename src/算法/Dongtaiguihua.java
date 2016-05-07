package 算法;

import java.util.Scanner;

public class Dongtaiguihua
{
    int min(int a, int b, int c)
    {
        int t=a < b ? a : b;
        return t < c ? t : c;
    }

    void editDistance(char[] s1, char[] s2)
    {
        int len1=s1.length;
        int len2=s2.length;
        int d[][]=new int[len1 + 1][len2 + 1];
        int i, j;
        for(i=0; i <= len1; i++)
            d[i][0]=i;
        for(j=0; j <= len2; j++)
            d[0][j]=j;
        for(i=1; i <= len1; i++)
            for(j=1; j <= len2; j++)
            {
                int cost=s1[i - 1] == s2[j - 1] ? 0 : 1;
                int deletion=d[i - 1][j] + 1;
                int insertion=d[i][j - 1] + 1;
                int substitution=d[i - 1][j - 1] + cost;
                d[i][j]=min(deletion, insertion, substitution);
            }
        System.out.println(d[len1][len2]);
    }

    public static void main(String[] args)
    {
        Dongtaiguihua ed=new Dongtaiguihua();

        Scanner in=new Scanner(System.in);
        String a=in.nextLine();
        String b=in.nextLine();
        in.close();
        ed.editDistance(a.toCharArray(), b.toCharArray());
    }
}
