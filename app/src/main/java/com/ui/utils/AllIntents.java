package com.ui.utils;


import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;




public class AllIntents
{
  public static Intent getAudioFileIntent(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    localIntent.putExtra("oneshot", 0);
    localIntent.putExtra("configchange", 0);
    Uri localUri = Uri.fromFile(new File(paramString));
    localIntent.setDataAndType(localUri, "audio/*");
    return localIntent;
  }

  public static Intent getChmFileIntent(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    Uri localUri = Uri.fromFile(new File(paramString));
    localIntent.setDataAndType(localUri, "application/x-chm");
    return localIntent;
  }

  public static Intent getExcelFileIntent(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    Uri localUri = Uri.fromFile(new File(paramString));
    localIntent.setDataAndType(localUri, "application/vnd.ms-excel");
    return localIntent;
  }

  public static Intent getHtmlFileIntent(String paramString)
  {
    Uri localUri = Uri.parse(paramString).buildUpon().encodedAuthority("com.android.htmlfileprovider").scheme("content").encodedPath(paramString).build();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(localUri, "text/html");
    return localIntent;
  }

  public static Intent getImageFileIntent(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    Uri localUri = Uri.fromFile(new File(paramString));
    localIntent.setDataAndType(localUri, "image/*");
    return localIntent;
  }
  
  
  /**
   * Get PDF file Intent
   */
  public static Intent getPdfFileIntent(String path){
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.addCategory(Intent.CATEGORY_DEFAULT);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
		Uri uri = Uri.fromFile(new File(path));
		i.setDataAndType(uri, "application/pdf");
		return i;
	}

  public static Intent getPdfFileIntentq(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    Uri localUri = Uri.fromFile(new File(paramString));
    localIntent.setDataAndType(localUri, "application/pdf");
    return localIntent;
  }

  public static Intent getPptFileIntent(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    Uri localUri = Uri.fromFile(new File(paramString));
    localIntent.setDataAndType(localUri, "application/vnd.ms-powerpoint");
    return localIntent;
  }

  
  
  public static Intent getTextFileIntent( String param, boolean paramBoolean)
  {
   Intent intent = new Intent("android.intent.action.VIEW");
   intent.addCategory("android.intent.category.DEFAULT");
   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
   if (paramBoolean)
   {
  Uri uri1 = Uri.parse(param );
  intent.setDataAndType(uri1, "text/plain");
   }
   else
   {
   Uri uri2 = Uri.fromFile(new File(param ));
  intent.setDataAndType(uri2, "text/plain");
   }
      return intent;
  }


  
  

  public static Intent getVideoFileIntent(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    localIntent.putExtra("oneshot", 0);
    localIntent.putExtra("configchange", 0);
    Uri localUri = Uri.fromFile(new File(paramString));
    localIntent.setDataAndType(localUri, "video/*");
    return localIntent;
  }

  public static Intent getWordFileIntent(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    Uri localUri = Uri.fromFile(new File(paramString));
    localIntent.setDataAndType(localUri, "application/msword");
    return localIntent;
  }
}
