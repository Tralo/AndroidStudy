package taotao.androidstudy;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
    }
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private View v_block;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        v_block = findViewById(R.id.v_block);
        anim1();
        anim2();
        anim3();
        anim4();
        anim5();

    }

    private void anim5() {
        ObjectAnimator translationUp = ObjectAnimator.ofInt(v_block,
                "backgroundColor", Color.RED, Color.BLUE, Color.GRAY,
                Color.GREEN);
        translationUp.setInterpolator(new DecelerateInterpolator());
        translationUp.setDuration(1500);
        translationUp.setRepeatCount(-1);
        translationUp.setRepeatMode(Animation.REVERSE);
        /*
         * ArgbEvaluator：这种评估者可以用来执行类型之间的插值整数值代表ARGB颜色。
         * FloatEvaluator：这种评估者可以用来执行浮点值之间的插值。
         * IntEvaluator：这种评估者可以用来执行类型int值之间的插值。
         * RectEvaluator：这种评估者可以用来执行类型之间的插值矩形值。
         *
         * 由于本例是改变View的backgroundColor属性的背景颜色所以此处使用ArgbEvaluator
         */

        translationUp.setEvaluator(new ArgbEvaluator());
        translationUp.start();

    }

    private void anim4() {
        AnimatorSet set = new AnimatorSet() ;
        ObjectAnimator anim = createRepeatAnimatorSet(tv4, "rotationX", 0f, 180f, 2000);
        ObjectAnimator anim2 = createRepeatAnimatorSet(tv4, "rotationX", 180f, 0f, 2000);
        ObjectAnimator anim3 = createRepeatAnimatorSet(tv4, "rotationY", 0f, 180f, 2000);
        ObjectAnimator anim4 = createRepeatAnimatorSet(tv4, "rotationY", 180f, 0f,2000);
        set.play(anim).before(anim2); //先执行anim动画之后在执行anim2
        set.play(anim3).before(anim4) ;
        set.start();
    }


    public ObjectAnimator createRepeatAnimatorSet(View v,String type,float x,float y,int duration){
        ObjectAnimator anim = ObjectAnimator.ofFloat(v,type,x,y);

        anim.setDuration(duration);
        anim.setRepeatCount(-1);
        anim.setRepeatMode(Animation.REVERSE);
        return anim;
    }

    public ObjectAnimator createAnimatorSet(View v,String type,float x,float y,int duration){
        ObjectAnimator anim = ObjectAnimator.ofFloat(v,type,x,y);
        anim.setDuration(duration);
        return anim;
    }



    private void anim3() {

        ObjectAnimator translationUp = ObjectAnimator.ofFloat(tv3,"Y",tv3.getY(),500);
        translationUp.setInterpolator(new DecelerateInterpolator());

        ObjectAnimator translationDown = ObjectAnimator.ofFloat(tv3,"X",tv3.getX(),500);
        translationDown.setInterpolator(new DecelerateInterpolator());
//        translationUp.setDuration(3000);
//        translationUp.setRepeatCount(-1);//设置动画重复次数，这里-1代表无限
//        translationUp.setRepeatMode(Animation.REVERSE);//设置动画循环模式。
//        translationUp.start();

        AnimatorSet set = new AnimatorSet();
        set.setDuration(3000);
        set.play(translationUp).with(translationDown);
        set.start();
    }




    private void anim2() {
        AnimatorSet animatorSet = new AnimatorSet();//组合动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(tv2, "scaleX", 1f, 0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(tv2, "scaleY", 1f, 0f);

        animatorSet.setDuration(2000);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.play(scaleX).with(scaleY);//两个动画同时开始
        animatorSet.start();

    }

    private void anim1() {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(tv1, "alpha", 0f, 1f);
        alpha.setDuration(2000);//设置动画时间
        alpha.setInterpolator(new DecelerateInterpolator());//设置动画插入器，减速
        alpha.setRepeatCount(-1);//设置动画重复次数，这里-1代表无限
        alpha.setRepeatMode(Animation.REVERSE);//设置动画循环模式。
        alpha.start();//启动动画。
    }




}
