package necessary.com.androidspikes;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Window;
import android.widget.Toast;

import com.example.tomaszkonieczny.myapplication.R;

public class SlideActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        Slide slide = new Slide();
        slide.excludeTarget(android.R.id.statusBarBackground, true);
        slide.excludeTarget(android.R.id.navigationBarBackground, true);
        slide.setDuration(1500);

        slide.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                Toast.makeText(SlideActivity.this, "Nice transition, isn't it?", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });

        getWindow().setEnterTransition(slide);
        getWindow().setExitTransition(slide);

        setContentView(R.layout.activity_slide);
    }

}
