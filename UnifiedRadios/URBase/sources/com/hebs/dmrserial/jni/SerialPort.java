package com.hebs.dmrserial.jni;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class SerialPort {

    /* renamed from: a, reason: collision with root package name */
    public final FileInputStream f5553a;

    /* renamed from: b, reason: collision with root package name */
    public final FileOutputStream f5554b;

    static {
        System.loadLibrary("serial_port");
    }

    public SerialPort(String str, int i5, int i6) throws IOException {
        File file = new File(str);
        if (!file.canRead() || !file.canWrite()) {
            throw new SecurityException();
        }
        FileDescriptor fileDescriptorOpen = open(file.getAbsolutePath(), i5, i6);
        if (fileDescriptorOpen == null) {
            throw new IOException();
        }
        this.f5553a = new FileInputStream(fileDescriptorOpen);
        this.f5554b = new FileOutputStream(fileDescriptorOpen);
    }

    private native FileDescriptor open(String str, int i5, int i6);

    public native int close();
}
