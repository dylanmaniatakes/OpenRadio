package org.conscrypt;

import java.security.PublicKey;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public final class TrustedCertificateIndex {
    private final Map<X500Principal, List<TrustAnchor>> subjectToTrustAnchors = new HashMap();

    public TrustedCertificateIndex() {
    }

    private void index(Set<TrustAnchor> set) {
        Iterator<TrustAnchor> it = set.iterator();
        while (it.hasNext()) {
            index(it.next());
        }
    }

    public Set<TrustAnchor> findAllByIssuerAndSignature(X509Certificate x509Certificate) {
        X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
        synchronized (this.subjectToTrustAnchors) {
            try {
                List<TrustAnchor> list = this.subjectToTrustAnchors.get(issuerX500Principal);
                if (list == null) {
                    return Collections.emptySet();
                }
                HashSet hashSet = new HashSet();
                for (TrustAnchor trustAnchor : list) {
                    try {
                        X509Certificate trustedCert = trustAnchor.getTrustedCert();
                        PublicKey publicKey = trustedCert != null ? trustedCert.getPublicKey() : trustAnchor.getCAPublicKey();
                        if (publicKey != null) {
                            x509Certificate.verify(publicKey);
                            hashSet.add(trustAnchor);
                        }
                    } catch (Exception unused) {
                    }
                }
                return hashSet;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public TrustAnchor findByIssuerAndSignature(X509Certificate x509Certificate) {
        X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
        synchronized (this.subjectToTrustAnchors) {
            try {
                List<TrustAnchor> list = this.subjectToTrustAnchors.get(issuerX500Principal);
                if (list == null) {
                    return null;
                }
                for (TrustAnchor trustAnchor : list) {
                    try {
                        X509Certificate trustedCert = trustAnchor.getTrustedCert();
                        x509Certificate.verify(trustedCert != null ? trustedCert.getPublicKey() : trustAnchor.getCAPublicKey());
                        return trustAnchor;
                    } catch (Exception unused) {
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public TrustAnchor findBySubjectAndPublicKey(X509Certificate x509Certificate) {
        X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
        synchronized (this.subjectToTrustAnchors) {
            try {
                List<TrustAnchor> list = this.subjectToTrustAnchors.get(subjectX500Principal);
                if (list == null) {
                    return null;
                }
                return findBySubjectAndPublicKey(x509Certificate, list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void reset() {
        synchronized (this.subjectToTrustAnchors) {
            this.subjectToTrustAnchors.clear();
        }
    }

    public TrustedCertificateIndex(Set<TrustAnchor> set) {
        index(set);
    }

    public TrustAnchor index(X509Certificate x509Certificate) {
        TrustAnchor trustAnchor = new TrustAnchor(x509Certificate, null);
        index(trustAnchor);
        return trustAnchor;
    }

    public void reset(Set<TrustAnchor> set) {
        synchronized (this.subjectToTrustAnchors) {
            reset();
            index(set);
        }
    }

    public void index(TrustAnchor trustAnchor) {
        X500Principal ca;
        X509Certificate trustedCert = trustAnchor.getTrustedCert();
        if (trustedCert != null) {
            ca = trustedCert.getSubjectX500Principal();
        } else {
            ca = trustAnchor.getCA();
        }
        synchronized (this.subjectToTrustAnchors) {
            try {
                List<TrustAnchor> arrayList = this.subjectToTrustAnchors.get(ca);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.subjectToTrustAnchors.put(ca, arrayList);
                } else if (trustedCert != null) {
                    Iterator<TrustAnchor> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (trustedCert.equals(it.next().getTrustedCert())) {
                            return;
                        }
                    }
                }
                arrayList.add(trustAnchor);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static TrustAnchor findBySubjectAndPublicKey(X509Certificate x509Certificate, Collection<TrustAnchor> collection) {
        PublicKey cAPublicKey;
        PublicKey publicKey = x509Certificate.getPublicKey();
        for (TrustAnchor trustAnchor : collection) {
            try {
                X509Certificate trustedCert = trustAnchor.getTrustedCert();
                if (trustedCert != null) {
                    cAPublicKey = trustedCert.getPublicKey();
                } else {
                    cAPublicKey = trustAnchor.getCAPublicKey();
                }
            } catch (Exception unused) {
            }
            if (cAPublicKey.equals(publicKey)) {
                return trustAnchor;
            }
            if ("X.509".equals(cAPublicKey.getFormat()) && "X.509".equals(publicKey.getFormat())) {
                byte[] encoded = cAPublicKey.getEncoded();
                byte[] encoded2 = publicKey.getEncoded();
                if (encoded2 != null && encoded != null && Arrays.equals(encoded, encoded2)) {
                    return trustAnchor;
                }
            }
        }
        return null;
    }
}
