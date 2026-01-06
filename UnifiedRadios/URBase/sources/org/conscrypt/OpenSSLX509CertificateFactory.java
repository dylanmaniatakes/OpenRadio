package org.conscrypt;

import com.unified.ur1.SatelliteTracker.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class OpenSSLX509CertificateFactory extends CertificateFactorySpi {
    private static final byte[] PKCS7_MARKER = {45, 45, 45, 45, 45, 66, 69, 71, 73, 78, 32, 80, 75, 67, 83, 55};
    private static final int PUSHBACK_SIZE = 64;
    private Parser<OpenSSLX509Certificate> certificateParser = new Parser<OpenSSLX509Certificate>() { // from class: org.conscrypt.OpenSSLX509CertificateFactory.1
        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509Certificate> fromPkcs7DerInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509Certificate.fromPkcs7DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509Certificate> fromPkcs7PemInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509Certificate.fromPkcs7PemInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509Certificate fromX509DerInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509Certificate.fromX509DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509Certificate fromX509PemInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509Certificate.fromX509PemInputStream(inputStream);
        }
    };
    private Parser<OpenSSLX509CRL> crlParser = new Parser<OpenSSLX509CRL>() { // from class: org.conscrypt.OpenSSLX509CertificateFactory.2
        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509CRL> fromPkcs7DerInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509CRL.fromPkcs7DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509CRL> fromPkcs7PemInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509CRL.fromPkcs7PemInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509CRL fromX509DerInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509CRL.fromX509DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509CRL fromX509PemInputStream(InputStream inputStream) throws ParsingException {
            return OpenSSLX509CRL.fromX509PemInputStream(inputStream);
        }
    };

    public static abstract class Parser<T> {
        private Parser() {
        }

        public abstract List<? extends T> fromPkcs7DerInputStream(InputStream inputStream) throws ParsingException;

        public abstract List<? extends T> fromPkcs7PemInputStream(InputStream inputStream) throws ParsingException;

        public abstract T fromX509DerInputStream(InputStream inputStream) throws ParsingException;

        public abstract T fromX509PemInputStream(InputStream inputStream) throws ParsingException;

        public T generateItem(InputStream inputStream) throws ParsingException, IOException {
            if (inputStream == null) {
                throw new ParsingException("inStream == null");
            }
            boolean zMarkSupported = inputStream.markSupported();
            if (zMarkSupported) {
                inputStream.mark(OpenSSLX509CertificateFactory.PKCS7_MARKER.length);
            }
            PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 64);
            try {
                byte[] bArr = new byte[OpenSSLX509CertificateFactory.PKCS7_MARKER.length];
                int i5 = pushbackInputStream.read(bArr);
                if (i5 < 0) {
                    throw new ParsingException("inStream is empty");
                }
                pushbackInputStream.unread(bArr, 0, i5);
                if (bArr[0] == 45) {
                    if (i5 != OpenSSLX509CertificateFactory.PKCS7_MARKER.length || !Arrays.equals(OpenSSLX509CertificateFactory.PKCS7_MARKER, bArr)) {
                        return fromX509PemInputStream(pushbackInputStream);
                    }
                    List<? extends T> listFromPkcs7PemInputStream = fromPkcs7PemInputStream(pushbackInputStream);
                    if (listFromPkcs7PemInputStream.size() == 0) {
                        return null;
                    }
                    listFromPkcs7PemInputStream.get(0);
                }
                if (bArr[4] != 6) {
                    return fromX509DerInputStream(pushbackInputStream);
                }
                List<? extends T> listFromPkcs7DerInputStream = fromPkcs7DerInputStream(pushbackInputStream);
                if (listFromPkcs7DerInputStream.size() == 0) {
                    return null;
                }
                return listFromPkcs7DerInputStream.get(0);
            } catch (Exception e5) {
                if (zMarkSupported) {
                    try {
                        inputStream.reset();
                    } catch (IOException unused) {
                    }
                }
                throw new ParsingException(e5);
            }
        }

        public Collection<? extends T> generateItems(InputStream inputStream) throws ParsingException, IOException {
            T tGenerateItem;
            if (inputStream == null) {
                throw new ParsingException("inStream == null");
            }
            try {
                if (inputStream.available() == 0) {
                    return new ArrayList();
                }
                boolean zMarkSupported = inputStream.markSupported();
                if (zMarkSupported) {
                    inputStream.mark(64);
                }
                PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 64);
                try {
                    byte[] bArr = new byte[OpenSSLX509CertificateFactory.PKCS7_MARKER.length];
                    int i5 = pushbackInputStream.read(bArr);
                    if (i5 < 0) {
                        throw new ParsingException("inStream is empty");
                    }
                    pushbackInputStream.unread(bArr, 0, i5);
                    if (i5 == OpenSSLX509CertificateFactory.PKCS7_MARKER.length && Arrays.equals(OpenSSLX509CertificateFactory.PKCS7_MARKER, bArr)) {
                        return fromPkcs7PemInputStream(pushbackInputStream);
                    }
                    if (bArr[4] == 6) {
                        return fromPkcs7DerInputStream(pushbackInputStream);
                    }
                    ArrayList arrayList = new ArrayList();
                    do {
                        if (zMarkSupported) {
                            inputStream.mark(64);
                        }
                        try {
                            tGenerateItem = generateItem(pushbackInputStream);
                            arrayList.add(tGenerateItem);
                        } catch (ParsingException unused) {
                            if (zMarkSupported) {
                                try {
                                    inputStream.reset();
                                } catch (IOException unused2) {
                                }
                            }
                            tGenerateItem = null;
                        }
                    } while (tGenerateItem != null);
                    return arrayList;
                } catch (Exception e5) {
                    if (zMarkSupported) {
                        try {
                            inputStream.reset();
                        } catch (IOException unused3) {
                        }
                    }
                    throw new ParsingException(e5);
                }
            } catch (IOException e6) {
                throw new ParsingException("Problem reading input stream", e6);
            }
        }
    }

    public static class ParsingException extends Exception {
        private static final long serialVersionUID = 8390802697728301325L;

        public ParsingException(String str) {
            super(str);
        }

        public ParsingException(Exception exc) {
            super(exc);
        }

        public ParsingException(String str, Exception exc) {
            super(str, exc);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CRL engineGenerateCRL(InputStream inputStream) throws CRLException {
        try {
            return this.crlParser.generateItem(inputStream);
        } catch (ParsingException e5) {
            throw new CRLException(e5);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection<? extends CRL> engineGenerateCRLs(InputStream inputStream) throws CRLException {
        if (inputStream == null) {
            return Collections.emptyList();
        }
        try {
            return this.crlParser.generateItems(inputStream);
        } catch (ParsingException e5) {
            throw new CRLException(e5);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream) throws CertificateException {
        return OpenSSLX509CertPath.fromEncoding(inputStream);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException {
        try {
            return this.certificateParser.generateItem(inputStream);
        } catch (ParsingException e5) {
            throw new CertificateException(e5);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection<? extends Certificate> engineGenerateCertificates(InputStream inputStream) throws CertificateException {
        try {
            return this.certificateParser.generateItems(inputStream);
        } catch (ParsingException e5) {
            throw new CertificateException(e5);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Iterator<String> engineGetCertPathEncodings() {
        return OpenSSLX509CertPath.getEncodingsIterator();
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream, String str) throws CertificateException {
        return OpenSSLX509CertPath.fromEncoding(inputStream, str);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(List<? extends Certificate> list) throws CertificateException {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            Certificate certificate = list.get(i5);
            if (certificate instanceof X509Certificate) {
                arrayList.add((X509Certificate) certificate);
            } else {
                throw new CertificateException(h.a(i5, "Certificate not X.509 type at index "));
            }
        }
        return new OpenSSLX509CertPath(arrayList);
    }
}
