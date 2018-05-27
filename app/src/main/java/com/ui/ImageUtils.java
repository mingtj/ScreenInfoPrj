package com.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.xutils.x;
import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ImageUtils {

	
	
	/**
     * ??剧ず??剧??锛?榛?璁ゆ????碉??
     *
     * @param imageView ??惧????т欢
     * @param iconUrl   ??剧????板??
     */
    public static void display(ImageView imageView, String iconUrl) {
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setIgnoreGif(false)//??????蹇界??gif??俱??false琛ㄧず涓?蹇界?ャ??涓????杩???ワ??榛?璁ゆ??true
                .setImageScaleType(ImageView.ScaleType.FIT_XY)//CENTER_CROP
                .setFailureDrawableId(R.drawable.app_logo)//???杞藉け璐ヤ???????剧??
                .setLoadingDrawableId(R.drawable.app_logo)//???杞戒腑??剧??
                .build();
        x.image().bind(imageView, iconUrl,imageOptions);
    }

    /**
     * ??剧ず???瑙???剧??
     *
     * @param imageView ??惧????т欢
     * @param iconUrl   ??剧????板??
     * @param radius    ???瑙????寰?锛?
     */
    public static void display(ImageView imageView, String iconUrl, int radius) {
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setRadius(DensityUtil.dip2px(radius))
                .setIgnoreGif(false)
                .setCrop(true)//??????瀵瑰?剧??杩?琛?瑁????
                .setFailureDrawableId(R.drawable.app_logo)//???杞藉け璐ヤ???????剧??
                .setLoadingDrawableId(R.drawable.app_logo)//???杞戒腑??剧??
                .build();
        x.image().bind(imageView, iconUrl, imageOptions);
    }

    /**
     * ??剧ず???褰㈠ご???锛?绗?涓?涓??????颁负true
     *
     * @param imageView  ??惧????т欢
     * @param iconUrl    ??剧????板??
     * @param isCircluar ????????剧ず???褰?
     */
    public static void display(ImageView imageView, String iconUrl, boolean isCircluar) {
    	if(iconUrl==null)
//    		iconUrl="file:///android_asset/app_logo.png";
    		iconUrl = "assets/app_logo.png";
    	System.out.println("==imgUrl=="+iconUrl);
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)//CENTER_CROP
//                .setFailureDrawableId(R.drawable.app_logo)//???杞藉け璐ヤ???????剧??
//                .setLoadingDrawableId(R.drawable.app_logo)//???杞戒腑??剧??
                .setCircular(isCircluar)
                .setCrop(true)
                .build();
        x.image().bind(imageView, iconUrl, imageOptions);
    }
    
    
//    public static void displayWebImg2(Context context,LinearLayout layout,String webString){
//    	if(webString==null||TextUtils.isEmpty(webString))
//    		return;
////    	webString = "<img src=\"http://f.hiphotos.baidu.com/zhidao/pic/item/2fdda3cc7cd98d104cc21595203fb80e7bec907b.jpg\"></p><p><img src=\"http://edu.tuanzitech.com/image/question/219/1479463724484967.png\">";
////    	<img src="http://edu.tuanzitech.com/image/question/219/1479463724484967.png">
//
//    	layout.removeAllViews();  //clear linearlayout
//    	List<String> imgList = new ArrayList<String>();
//    	System.out.println("--displayWebImg--"+webString);
//    	//??规??涓?
////    	imgList = getImgSrcList(webString);
//    	//??规??浜?
//    	imgList = getImageUrl(webString);
//    	
//        for (int i = 0; i < imgList.size(); i++) {
//            ImageView imageView = new ImageView(context);
//            imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));  //璁剧疆??剧??瀹介??
//            imageView.setPadding(0, 15, 0, 0);
//            display(imageView, imgList.get(i));
//            layout.addView(imageView); //??ㄦ??娣诲????剧??
//        }
//    }
    
    /**
     * 寰???扮??椤典腑??剧???????板??
     * 姝ｅ????归??缃?椤电????剧????炬?ワ????峰??缃?椤垫?煎?????????????剧????板??
     */
    public static List<String> getImgSrcList(String htmlStr) {
        List<String> pics = new ArrayList<String>();
//        String regEx_img = "<img.*?src=\"http://(.*?).png\""; // ??剧????炬?ュ?板??
        String regEx_img = "<img.*?src=\"http://(.*?).(?:png|jpg|bmp|jpeg)\""; // ??剧????炬?ュ?板??
        
        Pattern p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        Matcher m_image = p_image.matcher(htmlStr);
        String imgUrl = null;
        while (m_image.find()) {
            String src = m_image.group(1);
//            imgUrl = (src == null || src.trim().length() == 0) ? m_image.group(2).split("\\s+")[0] : m_image.group(2);
//            System.out.println("--srcs--"+imgUrl);
           if (src.length() < 300) {
                pics.add("http://" + src + ".jpg");
                //pics.add("http://f.hiphotos.baidu.com/zhidao/pic/item/2fdda3cc7cd98d104cc21595203fb80e7bec907b.jpg");
            }
        }
//        pics.addAll(pics);
        return pics;
    }
    
    // ??峰??img???绛炬?ｅ??  
    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";  
    // ??峰??src璺?寰????姝ｅ??  
    private  static final String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)";  
    
    /*** 
     * ??峰??ImageUrl??板?? 
     *  姝ｅ????归??缃?椤电????剧????炬?ワ????峰??缃?椤垫?煎?????????????剧????板??
     * @param HTML 
     * img???绛?
     * @return 
     */  
    public static List<String> getImageUrl(String HTML) {  
        Matcher matcher = Pattern.compile(IMGURL_REG).matcher(HTML);  
        List<String> listImgUrl = new ArrayList<String>();  
        while (matcher.find()) {  
            listImgUrl.add(matcher.group());  
        }  
        
        List<String> imgHttpUrls = new ArrayList<String>();
        //???杩?img?????????绛撅??寰???伴????㈢??http??板??
        imgHttpUrls =  getImageSrc(listImgUrl);
        return imgHttpUrls;
        
    }  
  
    /*** 
     * ??峰??ImageSrc??板?? 
     *  http???绛?
     * @param listImageUrl 
     * @return 
     */  
    public static List<String> getImageSrc(List<String> listImageUrl) {  
        List<String> listImgSrc = new ArrayList<String>();  
        for (String image : listImageUrl) {  
            Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(image);  
            while (matcher.find()) {  
                listImgSrc.add(matcher.group().substring(0, matcher.group().length() - 1));  
            }  
        }  
        return listImgSrc;  
    }  
    
    public static Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels) {
		// 创建一个和原始图片一样大小位图
		Bitmap roundConcerImage = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_4444);
		// 创建带有位图roundConcerImage的画布
		Canvas canvas = new Canvas(roundConcerImage);
		// 创建画笔
		Paint paint = new Paint();
		// 创建一个和原始图片一样大小的矩形
		Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		int centre = canvas.getWidth() / 2; // 获取圆心的x坐标
		int radius = (int) (centre); // 圆环的半径
		paint.setStrokeWidth(0); // 设置圆环的宽度
		paint.setAntiAlias(true); // 消除锯齿
		canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG));
		canvas.drawCircle(centre, centre, radius, paint); // 画出圆环
		// 设置相交模式
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		// 把图片画到矩形去
		canvas.drawBitmap(bitmap, null, rect, paint);
		return roundConcerImage;
	}
    
}