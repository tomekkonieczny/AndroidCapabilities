package necessary.com.androidspikes;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.StateListAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;

import com.example.tomaszkonieczny.myapplication.R;

public class FadeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        Fade fade = new Fade();
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        setContentView(R.layout.activity_fade);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // previously invisible view
                final View myView = findViewById(R.id.reveal_image);

                if (myView.getVisibility() == View.INVISIBLE) {
                    // get the center for the clipping circle
                    int cx = (myView.getLeft() + myView.getRight()) / 2;
                    int cy = (myView.getTop() + myView.getBottom()) / 2;

                    // get the final radius for the clipping circle
                    int finalRadius = Math.max(myView.getWidth(), myView.getHeight());

                    // create the animator for this view (the start radius is zero)
                    Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);
                    anim.setDuration(1500);

                    anim.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            findViewById(R.id.button2).setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });

                    myView.setVisibility(View.VISIBLE);
                    anim.start();
                } else {
                    // get the center for the clipping circle
                    int cx = (myView.getLeft() + myView.getRight()) / 2;
                    int cy = (myView.getTop() + myView.getBottom()) / 2;

                    // get the initial radius for the clipping circle
                    int initialRadius = myView.getWidth();

                    // create the animation (the final radius is zero)
                    Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);
                    anim.setDuration(1500);

                    // make the view invisible when the animation is done
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            myView.setVisibility(View.INVISIBLE);
                        }
                    });

                    // start the animation
                    anim.start();
                }
            }
        });
    }


}
