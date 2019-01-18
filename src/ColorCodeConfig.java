/**
 * @Author: CHEN
 * @Date: 2019/1/18 15:54
 */
public class ColorCodeConfig extends BarcodeConfig {
    public ColorCodeConfig() {
        marginLength = new DistrictConfig<>(10,5,10,5);
        borderLength = new DistrictConfig<>(1);
        paddingLength = new DistrictConfig<>(1,1,0,0);
        metaLength = new DistrictConfig<>(0);

        mainWidth = 60;
        mainHeight = 60;

        blockLengthInPixel = 14;

        CustomColor black=CustomColor.Y1U0V0;
        CustomColor white=CustomColor.Y1U1V1;
        marginBlock = new DistrictConfig<>(new BlackWhiteBlock(black,CustomColor.Y1UmVm));
        //borderBlock = new DistrictConfig<>(new BlackWhiteBlock());
        borderBlock=new DistrictConfig<>(new BlackWhiteBlock(CustomColor.Y0UmVm,CustomColor.Y1UmVm));
        paddingBlock = new DistrictConfig<>(new ColorBlock(1,new CustomColor[]{CustomColor.Y0U0V0,CustomColor.Y0U1V1}));
//        paddingBlock=new DistrictConfig<>(
//                new ColorBlock(1,new CustomColor[]{CustomColor.Y0U0V0,CustomColor.Y0U1V1}),
//                new ColorBlock(1,new CustomColor[]{CustomColor.Y0U0V0,CustomColor.Y0U1V1}),
//                new BlackWhiteBlock(black,white),
//                new BlackWhiteBlock(black,white),
//                new BlackWhiteBlock(black,white),
//                new BlackWhiteBlock(black,white),
//                new BlackWhiteBlock(black,white),
//                new BlackWhiteBlock(black,white)
//        );
        metaBlock=new DistrictConfig<>(new BlackWhiteBlock(CustomColor.Y0UmVm,CustomColor.Y1UmVm));

        mainBlock = new DistrictConfig<>(new ColorBlock(1,new CustomColor[]{CustomColor.Y0U0V0,CustomColor.Y0U1V1}));

        marginContent = new DistrictConfig<>(new BitContent(BitContent.ALL_ONES));
        borderContent = new DistrictConfig<>(new BitContent(BitContent.ALL_ZEROS));
        paddingContent = new DistrictConfig<>(new BitContent(BitContent.ALL_ZEROS));
        metaContent = new DistrictConfig<>(new BitContent(BitContent.ALL_ZEROS));

        hints.put(ShiftCodeColor.KEY_SIZE_RS_ERROR_CORRECTION,12);
        hints.put(ShiftCodeColor.KEY_LEVEL_RS_ERROR_CORRECTION,0.1);
        hints.put(ShiftCodeColor.KEY_NUMBER_RAPTORQ_SOURCE_BLOCKS,1);
        hints.put(ShiftCodeColor.KEY_PERCENT_RAPTORQ_REDUNDANT,0.5);
        hints.put(ShiftCodeColor.KEY_IS_REPLACE_LAST_RAPTORQ_SOURCE_PACKET_AS_REPAIR,true);
    }
}
