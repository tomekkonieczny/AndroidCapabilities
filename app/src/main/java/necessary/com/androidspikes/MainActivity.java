package necessary.com.androidspikes;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Pair;
import android.view.View;
import android.view.Window;

import com.example.tomaszkonieczny.myapplication.R;

/**
 * Created by Tomasz Konieczny on 2014-07-14.
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Fade());
        getWindow().setExitTransition(new Fade());

        setContentView(R.layout.main);

        findViewById(R.id.first_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExplodeActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, v, v.getTransitionName());
                startActivity(intent, options.toBundle());
            }
        });

        findViewById(R.id.first_image).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExplodeActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, options.toBundle());

                return true;
            }
        });

        findViewById(R.id.second_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FadeActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, v, v.getTransitionName());
                startActivity(intent, options.toBundle());
            }
        });

        findViewById(R.id.second_image).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                getWindow().setExitTransition(new Fade());
                Intent intent = new Intent(MainActivity.this, FadeActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, options.toBundle());

                return true;
            }
        });

        findViewById(R.id.third_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SlideActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, v, v.getTransitionName());
                startActivity(intent, options.toBundle());
            }
        });

        findViewById(R.id.third_image).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                getWindow().setExitTransition(new Slide());
                Intent intent = new Intent(MainActivity.this, SlideActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent, options.toBundle());

                return true;
            }
        });

        findViewById(R.id.fourth_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PairAcitivty.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        MainActivity.this,
                        Pair.create(findViewById(R.id.first_image), getString(R.string.pair1)),
                        Pair.create(findViewById(R.id.second_image), getString(R.string.pair2)),
                        Pair.create(findViewById(R.id.fourth_image), getString(R.string.pair3)),
                        Pair.create(findViewById(R.id.third_image), getString(R.string.pair4)));

                startActivity(intent, options.toBundle());
            }
        });
    }
}
