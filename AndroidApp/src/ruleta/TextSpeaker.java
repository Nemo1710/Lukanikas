package ruleta;

import java.util.Locale;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

public class TextSpeaker implements OnInitListener
{
  public TextToSpeech tts;

  public TextSpeaker(Context c)
  {
    tts = new TextToSpeech(c, this);
    tts.setLanguage( new Locale( "spa", "ESP" ));
  }

  @Override
  public void onInit(int status) {
    if(status != TextToSpeech.ERROR){
    	tts.setLanguage( new Locale( "spa", "ESP" ));
        //tts.setLanguage(Locale.US);
    }
  }
}