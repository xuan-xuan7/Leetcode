public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for(int i = 0; i < n; i ++){
            // 0开头为一字节符，直接跳过
            if(data[i] >> 7 == 0){
                continue;
            }
            int byteSize = 0;
            if(data[i] >> 3 == 30){
                byteSize = 4;
            } else if(data[i] >> 4 == 14){
                byteSize = 3;
            } else if(data[i] >> 5 == 6){
                byteSize = 2;
            } else {
                return false;
            }
            for(int j = 1; j < byteSize; j ++){
                if(i + j >= n){
                    return false;
                }
                if(data[i + j] >> 6 == 2){
                    continue;
                } else {
                    return false;
                }
            }
            i = i + byteSize - 1;
        }
        return true;
    }
}
