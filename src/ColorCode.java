import java.util.BitSet;

/**
 * @Author: CHEN
 * @Date: 2019/1/18 15:54
 */
public class ColorCode extends BlackWhiteCode{
    public static void main(String[] args){
        ColorCode colorCode=new ColorCode(new ColorCodeConfig());
        colorCode.toImages("./books/test.txt","./picture");
    }
    public ColorCode(BarcodeConfig config) {
        super(config);
        BitSet rightBarBitSet=new BitSet();
        for(int i=0;i<config.mainHeight;i+=2){
            rightBarBitSet.set(i);
        }
        BitContent rightBarContent=new BitContent(rightBarBitSet);

        config.paddingContent.set(District.RIGHT,rightBarContent);
        config.borderContent.set(District.RIGHT,new BitContent(BitContent.ALL_ZEROS));
    }
    protected BarcodeConfig configureTopBar(BarcodeConfig config,int data){
        BitSet topBarBitSet=Utils.intWithCRC8Checksum(data);
        BitContent topBarContent=new BitContent(topBarBitSet);
        config.paddingContent.set(District.UP,topBarContent);
        return config;
    }
    protected BarcodeConfig reconfigure(BarcodeConfig config,int barcodeIndex){
        //设置左边参考色
        BitSet leftBarBitSet=new BitSet();
        for(int i = 0;i < config.mainHeight; i++){
            if(i % 2 == 1)
                leftBarBitSet.set(i);
        }
        BitContent leftBarContent=new BitContent(leftBarBitSet);
        config.paddingContent.set(District.LEFT, leftBarContent);
//        if(barcodeIndex%2==0) {
//            BitSet leftBarBitSet=new BitSet();
//            leftBarBitSet.set(0);
//            leftBarBitSet.set(config.mainHeight-1);
//            BitContent leftBarContentEven=new BitContent(leftBarBitSet);
//            config.paddingContent.set(District.LEFT, leftBarContentEven);
//        }else{
//            BitContent leftBarContentOdd=new BitContent(BitContent.ALL_ZEROS);
//            config.paddingContent.set(District.LEFT, leftBarContentOdd);
//        }
        return config;
    }
}
