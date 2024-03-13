package com.yuvraj;
public class PatternAssignment {
    public static void main(String[] args) {
        // 1st one
        for(int i = 1; i <= 6; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }System.out.println();
        }

        // 2nd one
        for(int i = 0; i < 3; i++){
            for(int j = 0; j<= i; j++){
                System.out.print((char)('A'+j));
            }
            System.out.println();
        }

        //3rd one
        for(int i=1;i<=4;i++){
            for(int j=1;j<=4;j++){
                if(i==1||i==4){
                    System.out.print('$');
                }else{
                    if(j==1||j==4){
                        System.out.print('$');
                    }else{
                        System.out.print(' ');
                    }
                }
            }
            System.out.println();
        }
    }
}
