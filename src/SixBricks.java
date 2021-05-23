public class SixBricks {
    public static void main(String[] args) {

        final String Bricks="|**|";
        final String block="  ";

        /*三層結構*/
        String top="　＿　";
        String mid="／　＼";
        String down="＼＿／";


       String t1= "／＼";
       String t2= "＼／";




        for(int i=0;i<10;i++){
            StringBuilder sb=new StringBuilder();
            if(i%2==0)
                sb.append(block);
            for(int j=0;j<10;j++){
                sb.append(Bricks);


            }
            System.out.println(sb.toString());
        }

        System.out.println(top);
        System.out.println(mid);
        System.out.println(down);
        System.out.println(mid);
        int index=0;
        for(int i=0;i<6;i++){
            index++;
            StringBuilder sb=new StringBuilder();
//            if(index%3==0){
//                sb.append("　");
//            }

            for(int j=0;j<6;j++){
                if(i%2==0)
                    sb.append(t1);

                else
                    sb.append(t2);
            }
            System.out.println(sb.toString());
        }


    }
}
