package io.stream.delete_zero;

import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;


public class DeleteZeroInStream_My {
    public static void main(String[] args) throws IOException {
      final int BUFF_SIZE = 4;
      final byte[] DATA_IN = {0,1,1,1,0,1,0,1,0,1,0,0,1,1};
      byte[] dataOut;
      InputStream src = new ByteArrayInputStream(DATA_IN);
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      
      filterArray(src, out, BUFF_SIZE);
      dataOut = out.toByteArray();
      System.out.println(Arrays.toString(dataOut));
      
      
        
    }
  
  static void filterArray(InputStream in, OutputStream out, int buffSize) throws IOException{
    final int ZERO_STATE = 0;
    final int NUMBER_STATE = 1;
    byte[] buff = new byte[buffSize];
    int count;
    
    while((count = in.read(buff)) != -1){
      int state = ZERO_STATE;
      int previousIndex = 0;
      for(int index = 0; index < count; index++){
        switch(state){
          case ZERO_STATE:
          if(buff[index] == 0)
            state = ZERO_STATE;
          else{
            previousIndex = index;
            state = NUMBER_STATE;
          }
          break;
          case NUMBER_STATE:
          if(buff[index] == 0){
            out.write(buff, previousIndex, index - previousIndex);
            state = ZERO_STATE;
          }
          else{
            state = NUMBER_STATE;
          }
          break;
        }
      }
      if(state == ZERO_STATE){
        state = ZERO_STATE;
      }
      else
        out.write(buff, previousIndex , count - previousIndex);
    }        
  }


}

