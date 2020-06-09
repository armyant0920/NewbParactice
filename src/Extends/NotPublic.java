package Extends;

  class NotPublic {

     int x=2;
     int y=3;

     protected class NotPublic2{
         int z=4;
     }
     public int showTotal(){
         NotPublic2 n=new NotPublic2();
         return (x+y+n.z);
     }
}
