

public class test2 {
    public static void main(String[] args) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        String str = "make a fortune";
        byte[] byt = str.getBytes();
        for (byte b : byt) {
            System.out.println(b);
        }
        StringBuilder builder = new StringBuilder();
        int bit;
        bit = (byt[0] & 0x0f0) >> 4;
        // & 意思是对位“与”，只有两个数都为1，结果才为1，其他情况都为0
        // 0000 0110 1101 & 0000 1111 0000 = 0000 0110 0000 相当于保留中间四位二进制数；
        // 然后再右移4位变成 0000 0000 0110
        // bit是对应的十进制整数
        // chars[bit]是再得到对应的十六进制数
        builder.append(chars[bit]);
        bit = byt[0] & 0x0f;
        // 0000 0110 1101 & 0000 0000 1111 = 0000 0000 1101
        builder.append(chars[bit]);
        System.out.println(builder.toString());
    }
}
