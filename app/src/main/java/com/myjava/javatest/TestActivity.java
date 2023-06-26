package com.myjava.javatest;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.myjava.javatest.hello.OtherActivity;
import com.myjava.javatest.hello.SayHello;

import org.json.JSONObject;
import org.junit.Test;

import java.util.Scanner;

public class TestActivity extends AppCompatActivity {
    private int[] array = new int[]{3, 5, 53, 533};
    private IMyBinder myBinder;
    int i = 0;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        HandlerThread handlerThread = new HandlerThread("");
//        WebView web = findViewById(R.id.web);
//        WebSettings webSettings = web.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        //Android调用js代码
////        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        //js调用Android代码
//        web.addJavascriptInterface(new AndroidToJs(),"test");
//        web.loadUrl("file:///android_asset/js.html");
//        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                web.post(() -> web.loadUrl("javascript:callJS()"));
//                web.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        web.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
//                            @Override
//                            public void onReceiveValue(String value) {
//                                //此处为 js 返回的结果
//                                Toast.makeText(TestActivity.this,value,Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
//                });
//            }
//        });
//        web.setWebChromeClient(new WebChromeClient() {
//            @Override
//            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
//                AlertDialog.Builder b = new AlertDialog.Builder(TestActivity.this);
//                b.setTitle("Alert");
//                b.setMessage(message);
//                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        result.confirm();
//                    }
//                });
//                b.setCancelable(false);
//                b.create().show();
//                return true;
//            }
//
//        });
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher,options);
//        System.out.println(bitmap.getWidth());
//        System.out.println(bitmap.getHeight());
//        System.out.println(bitmap.getByteCount());
//        System.out.println(options.inTargetDensity);
//        System.out.println(options.inDensity);
//        System.out.println(getResources().getDisplayMetrics().densityDpi);

//        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                throw new NullPointerException("hello");
//                String s = SayHello.sayHello();
//                int sum = SayHello.sum(3, 5);
//                Toast.makeText(TestActivity.this, s, Toast.LENGTH_SHORT).show();
//                Toast.makeText(TestActivity.this, sum+"", Toast.LENGTH_SHORT).show();
//                SayHello.callSuperInstanceMethod();
//                int[] a = SayHello.operateIntArray();
//                for (int i = 0; i < a.length; i++) {
//                    System.out.println(a[i]);
//                }
//                String[] strings = SayHello.operateStringArray();
//                for (int i = 0; i <strings.length ; i++) {
//                    System.out.println(strings[i]);
//                }
//                Person[] person = SayHello.operateObjectArray();
//                for (int i = 0; i < person.length; i++) {
//                    System.out.println(person[i].getName());
//                }
//                try {
//                    SayHello.throwException();
//                } catch (IllegalArgumentException e) {
//                    e.printStackTrace();
//                }
////                SayHello.nativeInit();
//            }
//        });
//        startActivity(new Intent(this, FirstActivity.class));
//        finish();
//        File file = getFilesDir();
//        file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
//        Intent intent = new Intent(this, MyService.class);
//        bindService(intent, new MyConn(), BIND_AUTO_CREATE);
//        try {
//            invoke();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//        viewById = findViewById(R.id.tv);
//        overridePendingTransition(0, 0);
//        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    invoke();
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Looper.prepare();
////                AlertDialog dialog = new AlertDialog.Builder(TestActivity.this).setTitle(R.string.app_name).create();
////                dialog.show();
////
////
//                        viewById = new TextView(TestActivity.this);
//                        TestActivity.this.getWindowManager().addView(viewById, new WindowManager.LayoutParams());
//                        viewById.setText("gdsga");
//
////                        viewById.setText("Gfgfddgfgfdgfh");
////                        viewById.setTextColor(Color.RED);
////                        viewById.setHeight(1000);
////                Toast.makeText(TestActivity.this, "gdsg", Toast.LENGTH_SHORT).show();
//                        Looper.loop();
//
//                    }
//                }).start();
//                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                    transaction.add(R.id.fragment, new MyFragment().newInstance("fdsg"));
//                    transaction.addToBackStack(null);
//                    transaction.commit();
//                MyBroad myBroad = new MyBroad();
//                IntentFilter intentFilter = new IntentFilter();
//                // 2. 设置接收广播的类型
//                intentFilter.addAction("fgrfg");//
////                sendBroadcast(new Intent("klio"));
//                registerReceiver(myBroad, intentFilter);

//                Intent intent1 = new Intent(TestActivity.this, MyBroad.class);
//                intent1.setAction("klio");
//                sendBroadcast(intent1);
//                Pair<View, String> pair1 = Pair.create(findViewById(R.id.img), "goods_img");
//                Intent intent1 = new Intent(TestActivity.this,MainActivity.class);
//                 startActivity(intent1, ActivityOptions.makeSceneTransitionAnimation(TestActivity.this,findViewById(R.id.img),"goods_img").toBundle());

//                startActivity(new Intent(TestActivity.this, OtherActivity.class));
//                finish();
//            }
//        });
//
//        findViewById(R.id.bt1).setOnClickListener(v -> {
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.fragment, new MyFragmentB().newInstance("fdsg"));
//            transaction.addToBackStack("det");
//            transaction.commit();
//        });
//        Log.d(TAG, "onCreate: ");
//        if (!Settings.canDrawOverlays(this)) {
//            Intent intent2 = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
//                    Uri.parse("package:" + getPackageName()));
//            startActivityForResult(intent2, 10);
//        }
//       findViewById(R.id.img) .setOnClickListener(v -> {
//           Intent intent = new Intent(Intent.ACTION_MAIN);
//           intent.addCategory(Intent.CATEGORY_LAUNCHER);
//           ComponentName componentName = new ComponentName("story.photo.test", "story.photo.test.MainActivity");
//           intent.setComponent(componentName);
//           startActivity(intent);
//           System.out.println(getTaskId());
//       });
        SayHello.nativeInit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if (!Settings.canDrawOverlays(this)) {
                // SYSTEM_ALERT_WINDOW permission not granted...
                Toast.makeText(TestActivity.this, "not granted", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private static final String TAG = "TestActivity";

    public void invoke() throws RemoteException {
        myBinder.invokeMethodMyService();
    }

    TextView viewById;

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 90) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                System.out.println("ok");
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }

    private class MyConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = IMyBinder.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        getSupportFragmentManager().beginTransaction().
        return super.onKeyDown(keyCode, event);
    }

    public void getAnim() {
        View view = new View(this);
        ObjectAnimator.ofFloat(view, "translationX", 0, 100).setDuration(100).start();
    }

    private View view;

    public void getLayoutParams() {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        params.width += 100;
        params.leftMargin += 100;
        view.requestLayout();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (1 == 1) {
            return false;
        }
        return super.onTouchEvent(event);
    }

    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
    }
}
