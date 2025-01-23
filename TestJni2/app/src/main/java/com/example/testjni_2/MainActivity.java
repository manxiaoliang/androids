package com.example.testjni_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testjni_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'testjni_2' library on application startup.
//    static {
//        System.loadLibrary("testjni_2");
//    }

    private ActivityMainBinding binding;

    GL2JNIView mView_1;
    GL2JNIView mView_2;
    GL2JNIView mView_3;
    GL2JNIView mView_4;
    private GLSurfaceView mGLSurfaceView;
    private GLSurfaceView mGLSurfaceView_1;
    private GLSurfaceView mGLSurfaceView_2;
    private GLSurfaceView mGLSurfaceView_3;
    private final int CONTEXT_CLIENT_VERSION = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGLSurfaceView   = new GLSurfaceView ( this );
        mGLSurfaceView_1 = new GLSurfaceView ( this );
        mGLSurfaceView_2 = new GLSurfaceView ( this );
        mGLSurfaceView_3 = new GLSurfaceView ( this );
        if ( detectOpenGLES30() )
        {
            // Tell the surface view we want to create an OpenGL ES 3.0-compatible
            // context, and set an OpenGL ES 3.0-compatible renderer.
            mGLSurfaceView.setEGLContextClientVersion ( CONTEXT_CLIENT_VERSION );
            mGLSurfaceView.setEGLConfigChooser(8,8,8,8,16,0);
            mGLSurfaceView.getHolder().setFormat(PixelFormat.TRANSLUCENT);
            mGLSurfaceView.setRenderer ( new HelloTriangleRenderer ( this ) );

            mGLSurfaceView_1.setEGLContextClientVersion ( CONTEXT_CLIENT_VERSION );
            mGLSurfaceView_1.setEGLConfigChooser(8,8,8,8,16,0);
            mGLSurfaceView_1.getHolder().setFormat(PixelFormat.TRANSLUCENT);
            mGLSurfaceView_1.setRenderer ( new HelloTriangleRenderer_1 ( this ) );

            mGLSurfaceView_2.setEGLContextClientVersion ( CONTEXT_CLIENT_VERSION );
            mGLSurfaceView_2.setEGLConfigChooser(8,8,8,8,16,0);
            mGLSurfaceView_2.getHolder().setFormat(PixelFormat.TRANSLUCENT);
            mGLSurfaceView_2.setRenderer ( new HelloTriangleRenderer_2 ( this ) );

            mGLSurfaceView_3.setEGLContextClientVersion ( CONTEXT_CLIENT_VERSION );
            mGLSurfaceView_3.setEGLConfigChooser(8,8,8,8,16,0);
            mGLSurfaceView_3.getHolder().setFormat(PixelFormat.TRANSLUCENT);
            mGLSurfaceView_3.setRenderer ( new HelloTriangleRenderer_3 ( this ) );
//            mGLSurfaceView_1.setZOrderOnTop(true);

        }
        else
        {
//            Log.e ( "HelloTriangle", "OpenGL ES 3.0 not supported on device.  Exiting..." );
            finish();

        }




        FrameLayout layout = new FrameLayout(this);

        layout.setBackgroundColor(Color.TRANSPARENT);
        layout.getBackground().setAlpha(10);

        layout.addView(mGLSurfaceView);
        layout.addView(mGLSurfaceView_1);
        layout.addView(mGLSurfaceView_2);
        layout.addView(mGLSurfaceView_3);

        setContentView(layout);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

//        // Example of a call to a native method
//        TextView tv = binding.sampleText;
//        tv.setText(GL2JNILib.stringFromJNI());
    }

    private boolean detectOpenGLES30()
    {
        ActivityManager am =
                ( ActivityManager ) getSystemService ( Context.ACTIVITY_SERVICE );
        ConfigurationInfo info = am.getDeviceConfigurationInfo();
        return ( info.reqGlEsVersion >= 0x30000 );
    }


    /**
     * A native method that is implemented by the 'testjni_2' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
}