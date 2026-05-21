package c3;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.ws.WebSocketProtocol;
import org.conscrypt.PSKKeyManager;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public class m {

    /* renamed from: A, reason: collision with root package name */
    public static final HashMap f4547A;

    /* renamed from: B, reason: collision with root package name */
    public static final HashMap f4548B;

    /* renamed from: C, reason: collision with root package name */
    public static final /* synthetic */ m[] f4549C;

    /* renamed from: m, reason: collision with root package name */
    public static final m f4550m;
    public static final m n;

    /* renamed from: o, reason: collision with root package name */
    public static final m f4551o;

    /* renamed from: p, reason: collision with root package name */
    public static final m f4552p;

    /* renamed from: q, reason: collision with root package name */
    public static final g f4553q;

    /* renamed from: r, reason: collision with root package name */
    public static final m f4554r;

    /* renamed from: s, reason: collision with root package name */
    public static final i f4555s;

    /* renamed from: t, reason: collision with root package name */
    public static final m f4556t;

    /* renamed from: u, reason: collision with root package name */
    public static final m f4557u;

    /* renamed from: v, reason: collision with root package name */
    public static final m f4558v;

    /* renamed from: w, reason: collision with root package name */
    public static final m f4559w;

    /* renamed from: x, reason: collision with root package name */
    public static final m f4560x;

    /* renamed from: y, reason: collision with root package name */
    public static final m f4561y;

    /* renamed from: z, reason: collision with root package name */
    public static final HashMap f4562z;

    /* renamed from: j, reason: collision with root package name */
    public final String f4563j;

    /* renamed from: k, reason: collision with root package name */
    public final String f4564k;

    /* renamed from: l, reason: collision with root package name */
    public final int f4565l;

    /* JADX INFO: Fake field, exist only in values array */
    m EF0;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r61v7, types: [c3.g] */
    /* JADX WARN: Type inference failed for: r86v4, types: [c3.i] */
    static {
        m mVar = new m() { // from class: c3.d
        };
        m mVar2 = new m("AC", "Ascension Island", "ASC", 1, -1);
        m mVar3 = new m("AD", "Andorra", "AND", 2, 20);
        m mVar4 = new m("AE", "United Arab Emirates", "ARE", 3, 784);
        m mVar5 = new m("AF", "Afghanistan", "AFG", 4, 4);
        m mVar6 = new m("AG", "Antigua and Barbuda", "ATG", 5, 28);
        m mVar7 = new m("AI", "Anguilla", "AIA", 6, 660);
        m mVar8 = new m("AL", "Albania", "ALB", 7, 8);
        m mVar9 = new m("AM", "Armenia", "ARM", 8, 51);
        m mVar10 = new m("AN", "Netherlands Antilles", "ANT", 9, 530);
        f4550m = mVar10;
        m mVar11 = new m("AO", "Angola", "AGO", 10, 24);
        m mVar12 = new m("AQ", "Antarctica", "ATA", 11, 10);
        m mVar13 = new m("AR", "Argentina", "ARG", 12, 32);
        m mVar14 = new m("AS", "American Samoa", "ASM", 13, 16);
        m mVar15 = new m("AT", "Austria", "AUT", 14, 40);
        m mVar16 = new m("AU", "Australia", "AUS", 15, 36);
        m mVar17 = new m("AW", "Aruba", "ABW", 16, 533);
        m mVar18 = new m("AX", "Åland Islands", "ALA", 17, 248);
        m mVar19 = new m("AZ", "Azerbaijan", "AZE", 18, 31);
        m mVar20 = new m("BA", "Bosnia and Herzegovina", "BIH", 19, 70);
        m mVar21 = new m("BB", "Barbados", "BRB", 20, 52);
        m mVar22 = new m("BD", "Bangladesh", "BGD", 21, 50);
        m mVar23 = new m("BE", "Belgium", "BEL", 22, 56);
        m mVar24 = new m("BF", "Burkina Faso", "BFA", 23, 854);
        m mVar25 = new m("BG", "Bulgaria", "BGR", 24, 100);
        m mVar26 = new m("BH", "Bahrain", "BHR", 25, 48);
        m mVar27 = new m("BI", "Burundi", "BDI", 26, 108);
        m mVar28 = new m("BJ", "Benin", "BEN", 27, 204);
        m mVar29 = new m("BL", "Saint Barthélemy", "BLM", 28, 652);
        m mVar30 = new m("BM", "Bermuda", "BMU", 29, 60);
        m mVar31 = new m("BN", "Brunei Darussalam", "BRN", 30, 96);
        m mVar32 = new m("BO", "Bolivia, Plurinational State of", "BOL", 31, 68);
        m mVar33 = new m("BQ", "Bonaire, Sint Eustatius and Saba", "BES", 32, 535);
        m mVar34 = new m("BR", "Brazil", "BRA", 33, 76);
        m mVar35 = new m("BS", "Bahamas", "BHS", 34, 44);
        m mVar36 = new m("BT", "Bhutan", "BTN", 35, 64);
        m mVar37 = new m("BU", "Burma", "BUR", 36, 104);
        n = mVar37;
        m mVar38 = new m("BV", "Bouvet Island", "BVT", 37, 74);
        m mVar39 = new m("BW", "Botswana", "BWA", 38, 72);
        m mVar40 = new m("BY", "Belarus", "BLR", 39, 112);
        m mVar41 = new m("BZ", "Belize", "BLZ", 40, 84);
        m mVar42 = new m() { // from class: c3.e
        };
        m mVar43 = new m("CC", "Cocos (Keeling) Islands", "CCK", 42, 166);
        m mVar44 = new m("CD", "Congo, the Democratic Republic of the", "COD", 43, 180);
        f4551o = mVar44;
        m mVar45 = new m("CF", "Central African Republic", "CAF", 44, 140);
        m mVar46 = new m("CG", "Congo", "COG", 45, 178);
        m mVar47 = new m("CH", "Switzerland", "CHE", 46, 756);
        m mVar48 = new m("CI", "Côte d'Ivoire", "CIV", 47, 384);
        m mVar49 = new m("CK", "Cook Islands", "COK", 48, 184);
        m mVar50 = new m("CL", "Chile", "CHL", 49, 152);
        m mVar51 = new m("CM", "Cameroon", "CMR", 50, 120);
        m mVar52 = new m() { // from class: c3.f
        };
        m mVar53 = new m("CO", "Colombia", "COL", 52, 170);
        m mVar54 = new m("CP", "Clipperton Island", "CPT", 53, -1);
        m mVar55 = new m("CR", "Costa Rica", "CRI", 54, 188);
        m mVar56 = new m("CS", "Serbia and Montenegro", "SCG", 55, 891);
        f4552p = mVar56;
        m mVar57 = new m("CU", "Cuba", "CUB", 56, 192);
        m mVar58 = new m("CV", "Cape Verde", "CPV", 57, 132);
        m mVar59 = new m("CW", "Curaçao", "CUW", 58, 531);
        m mVar60 = new m("CX", "Christmas Island", "CXR", 59, 162);
        m mVar61 = new m("CY", "Cyprus", "CYP", 60, 196);
        m mVar62 = new m("CZ", "Czech Republic", "CZE", 61, 203);
        ?? r61 = new m() { // from class: c3.g
        };
        f4553q = r61;
        m mVar63 = new m("DG", "Diego Garcia", "DGA", 63, -1);
        m mVar64 = new m("DJ", "Djibouti", "DJI", 64, 262);
        m mVar65 = new m("DK", "Denmark", "DNK", 65, 208);
        m mVar66 = new m("DM", "Dominica", "DMA", 66, 212);
        m mVar67 = new m("DO", "Dominican Republic", "DOM", 67, 214);
        m mVar68 = new m("DZ", "Algeria", "DZA", 68, 12);
        m mVar69 = new m("EA", "Ceuta, Melilla", null, 69, -1);
        m mVar70 = new m("EC", "Ecuador", "ECU", 70, 218);
        m mVar71 = new m("EE", "Estonia", "EST", 71, 233);
        m mVar72 = new m("EG", "Egypt", "EGY", 72, 818);
        m mVar73 = new m("EH", "Western Sahara", "ESH", 73, 732);
        m mVar74 = new m("ER", "Eritrea", "ERI", 74, 232);
        m mVar75 = new m("ES", "Spain", "ESP", 75, 724);
        m mVar76 = new m("ET", "Ethiopia", "ETH", 76, 231);
        m mVar77 = new m("EU", "European Union", null, 77, -1);
        m mVar78 = new m("EZ", "Eurozone", null, 78, -1);
        m mVar79 = new m("FI", "Finland", "FIN", 79, 246);
        f4554r = mVar79;
        m mVar80 = new m("FJ", "Fiji", "FJI", 80, 242);
        m mVar81 = new m("FK", "Falkland Islands (Malvinas)", "FLK", 81, 238);
        m mVar82 = new m("FM", "Micronesia, Federated States of", "FSM", 82, 583);
        m mVar83 = new m("FO", "Faroe Islands", "FRO", 83, 234);
        m mVar84 = new m() { // from class: c3.h
        };
        m mVar85 = new m("FX", "France, Metropolitan", "FXX", 85, 249);
        m mVar86 = new m("GA", "Gabon", "GAB", 86, 266);
        ?? r86 = new m() { // from class: c3.i
        };
        f4555s = r86;
        m mVar87 = new m("GD", "Grenada", "GRD", 88, StatusLine.HTTP_PERM_REDIRECT);
        m mVar88 = new m("GE", "Georgia", "GEO", 89, 268);
        m mVar89 = new m("GF", "French Guiana", "GUF", 90, 254);
        m mVar90 = new m("GG", "Guernsey", "GGY", 91, 831);
        m mVar91 = new m("GH", "Ghana", "GHA", 92, 288);
        m mVar92 = new m("GI", "Gibraltar", "GIB", 93, 292);
        m mVar93 = new m("GL", "Greenland", "GRL", 94, 304);
        m mVar94 = new m("GM", "Gambia", "GMB", 95, 270);
        m mVar95 = new m("GN", "Guinea", "GIN", 96, 324);
        m mVar96 = new m("GP", "Guadeloupe", "GLP", 97, 312);
        m mVar97 = new m("GQ", "Equatorial Guinea", "GNQ", 98, 226);
        m mVar98 = new m("GR", "Greece", "GRC", 99, 300);
        m mVar99 = new m("GS", "South Georgia and the South Sandwich Islands", "SGS", 100, 239);
        m mVar100 = new m("GT", "Guatemala", "GTM", 101, 320);
        m mVar101 = new m("GU", "Guam", "GUM", 102, 316);
        m mVar102 = new m("GW", "Guinea-Bissau", "GNB", 103, 624);
        m mVar103 = new m("GY", "Guyana", "GUY", 104, 328);
        m mVar104 = new m("HK", "Hong Kong", "HKG", 105, 344);
        m mVar105 = new m("HM", "Heard Island and McDonald Islands", "HMD", 106, 334);
        m mVar106 = new m("HN", "Honduras", "HND", 107, 340);
        m mVar107 = new m("HR", "Croatia", "HRV", 108, 191);
        m mVar108 = new m("HT", "Haiti", "HTI", 109, 332);
        m mVar109 = new m("HU", "Hungary", "HUN", 110, 348);
        m mVar110 = new m("IC", "Canary Islands", null, 111, -1);
        m mVar111 = new m("ID", "Indonesia", "IDN", 112, 360);
        m mVar112 = new m("IE", "Ireland", "IRL", 113, 372);
        m mVar113 = new m("IL", "Israel", "ISR", 114, 376);
        m mVar114 = new m("IM", "Isle of Man", "IMN", 115, 833);
        m mVar115 = new m("IN", "India", "IND", 116, 356);
        m mVar116 = new m("IO", "British Indian Ocean Territory", "IOT", 117, 86);
        m mVar117 = new m("IQ", "Iraq", "IRQ", 118, 368);
        m mVar118 = new m("IR", "Iran, Islamic Republic of", "IRN", 119, 364);
        m mVar119 = new m("IS", "Iceland", "ISL", 120, 352);
        m mVar120 = new m() { // from class: c3.j
        };
        m mVar121 = new m("JE", "Jersey", "JEY", 122, 832);
        m mVar122 = new m("JM", "Jamaica", "JAM", 123, 388);
        m mVar123 = new m("JO", "Jordan", "JOR", 124, 400);
        m mVar124 = new m() { // from class: c3.k
        };
        m mVar125 = new m("KE", "Kenya", "KEN", WebSocketProtocol.PAYLOAD_SHORT, 404);
        m mVar126 = new m("KG", "Kyrgyzstan", "KGZ", 127, 417);
        m mVar127 = new m("KH", "Cambodia", "KHM", 128, 116);
        m mVar128 = new m("KI", "Kiribati", "KIR", 129, 296);
        m mVar129 = new m("KM", "Comoros", "COM", 130, 174);
        m mVar130 = new m("KN", "Saint Kitts and Nevis", "KNA", 131, 659);
        m mVar131 = new m("KP", "Korea, Democratic People's Republic of", "PRK", 132, 408);
        m mVar132 = new m() { // from class: c3.l
        };
        m mVar133 = new m("KW", "Kuwait", "KWT", 134, 414);
        m mVar134 = new m("KY", "Cayman Islands", "CYM", 135, 136);
        m mVar135 = new m("KZ", "Kazakhstan", "KAZ", 136, 398);
        m mVar136 = new m("LA", "Lao People's Democratic Republic", "LAO", 137, 418);
        m mVar137 = new m("LB", "Lebanon", "LBN", 138, 422);
        m mVar138 = new m("LC", "Saint Lucia", "LCA", 139, 662);
        m mVar139 = new m("LI", "Liechtenstein", "LIE", 140, 438);
        m mVar140 = new m("LK", "Sri Lanka", "LKA", ModuleDescriptor.MODULE_VERSION, 144);
        m mVar141 = new m("LR", "Liberia", "LBR", 142, 430);
        m mVar142 = new m("LS", "Lesotho", "LSO", 143, 426);
        m mVar143 = new m("LT", "Lithuania", "LTU", 144, 440);
        m mVar144 = new m("LU", "Luxembourg", "LUX", 145, 442);
        m mVar145 = new m("LV", "Latvia", "LVA", 146, 428);
        m mVar146 = new m("LY", "Libya", "LBY", 147, 434);
        m mVar147 = new m("MA", "Morocco", "MAR", 148, 504);
        m mVar148 = new m("MC", "Monaco", "MCO", 149, 492);
        m mVar149 = new m("MD", "Moldova, Republic of", "MDA", 150, 498);
        m mVar150 = new m("ME", "Montenegro", "MNE", 151, 499);
        m mVar151 = new m("MF", "Saint Martin (French part)", "MAF", 152, 663);
        m mVar152 = new m("MG", "Madagascar", "MDG", 153, 450);
        m mVar153 = new m("MH", "Marshall Islands", "MHL", 154, 584);
        m mVar154 = new m("MK", "North Macedonia, Republic of", "MKD", 155, 807);
        m mVar155 = new m("ML", "Mali", "MLI", 156, 466);
        m mVar156 = new m("MM", "Myanmar", "MMR", 157, 104);
        f4556t = mVar156;
        m mVar157 = new m("MN", "Mongolia", "MNG", 158, 496);
        m mVar158 = new m("MO", "Macao", "MAC", 159, 446);
        m mVar159 = new m("MP", "Northern Mariana Islands", "MNP", 160, 580);
        m mVar160 = new m("MQ", "Martinique", "MTQ", 161, 474);
        m mVar161 = new m("MR", "Mauritania", "MRT", 162, 478);
        m mVar162 = new m("MS", "Montserrat", "MSR", 163, 500);
        m mVar163 = new m("MT", "Malta", "MLT", 164, 470);
        m mVar164 = new m("MU", "Mauritius", "MUS", 165, 480);
        m mVar165 = new m("MV", "Maldives", "MDV", 166, 462);
        m mVar166 = new m("MW", "Malawi", "MWI", 167, 454);
        m mVar167 = new m("MX", "Mexico", "MEX", 168, 484);
        m mVar168 = new m("MY", "Malaysia", "MYS", 169, 458);
        m mVar169 = new m("MZ", "Mozambique", "MOZ", 170, 508);
        m mVar170 = new m("NA", "Namibia", "NAM", 171, 516);
        m mVar171 = new m("NC", "New Caledonia", "NCL", 172, 540);
        m mVar172 = new m("NE", "Niger", "NER", 173, 562);
        m mVar173 = new m("NF", "Norfolk Island", "NFK", 174, 574);
        m mVar174 = new m("NG", "Nigeria", "NGA", 175, 566);
        m mVar175 = new m("NI", "Nicaragua", "NIC", 176, 558);
        m mVar176 = new m("NL", "Netherlands", "NLD", 177, 528);
        m mVar177 = new m("NO", "Norway", "NOR", 178, 578);
        m mVar178 = new m("NP", "Nepal", "NPL", 179, 524);
        m mVar179 = new m("NR", "Nauru", "NRU", 180, 520);
        m mVar180 = new m("NT", "Neutral Zone", "NTZ", 181, 536);
        f4557u = mVar180;
        m mVar181 = new m("NU", "Niue", "NIU", 182, 570);
        m mVar182 = new m("NZ", "New Zealand", "NZL", 183, 554);
        m mVar183 = new m("OM", "Oman", "OMN", 184, 512);
        m mVar184 = new m("PA", "Panama", "PAN", 185, 591);
        m mVar185 = new m("PE", "Peru", "PER", 186, 604);
        m mVar186 = new m("PF", "French Polynesia", "PYF", 187, 258);
        m mVar187 = new m("PG", "Papua New Guinea", "PNG", 188, 598);
        m mVar188 = new m("PH", "Philippines", "PHL", 189, 608);
        m mVar189 = new m("PK", "Pakistan", "PAK", 190, 586);
        m mVar190 = new m("PL", "Poland", "POL", 191, 616);
        m mVar191 = new m("PM", "Saint Pierre and Miquelon", "SPM", 192, 666);
        m mVar192 = new m("PN", "Pitcairn", "PCN", 193, 612);
        m mVar193 = new m("PR", "Puerto Rico", "PRI", 194, 630);
        m mVar194 = new m("PS", "Palestine, State of", "PSE", 195, 275);
        m mVar195 = new m("PT", "Portugal", "PRT", 196, 620);
        m mVar196 = new m("PW", "Palau", "PLW", 197, 585);
        m mVar197 = new m("PY", "Paraguay", "PRY", 198, 600);
        m mVar198 = new m("QA", "Qatar", "QAT", 199, 634);
        m mVar199 = new m("RE", "Réunion", "REU", 200, 638);
        m mVar200 = new m("RO", "Romania", "ROU", 201, 642);
        m mVar201 = new m("RS", "Serbia", "SRB", 202, 688);
        m mVar202 = new m("RU", "Russian Federation", "RUS", 203, 643);
        m mVar203 = new m("RW", "Rwanda", "RWA", 204, 646);
        m mVar204 = new m("SA", "Saudi Arabia", "SAU", 205, 682);
        m mVar205 = new m("SB", "Solomon Islands", "SLB", 206, 90);
        m mVar206 = new m("SC", "Seychelles", "SYC", 207, 690);
        m mVar207 = new m("SD", "Sudan", "SDN", 208, 729);
        m mVar208 = new m("SE", "Sweden", "SWE", 209, 752);
        m mVar209 = new m("SF", "Finland", "FIN", 210, 246);
        m mVar210 = new m("SG", "Singapore", "SGP", 211, 702);
        m mVar211 = new m("SH", "Saint Helena, Ascension and Tristan da Cunha", "SHN", 212, 654);
        m mVar212 = new m("SI", "Slovenia", "SVN", 213, 705);
        m mVar213 = new m("SJ", "Svalbard and Jan Mayen", "SJM", 214, 744);
        m mVar214 = new m("SK", "Slovakia", "SVK", 215, 703);
        m mVar215 = new m("SL", "Sierra Leone", "SLE", 216, 694);
        m mVar216 = new m("SM", "San Marino", "SMR", 217, 674);
        m mVar217 = new m("SN", "Senegal", "SEN", 218, 686);
        m mVar218 = new m("SO", "Somalia", "SOM", 219, 706);
        m mVar219 = new m("SR", "Suriname", "SUR", 220, 740);
        m mVar220 = new m("SS", "South Sudan", "SSD", 221, 728);
        m mVar221 = new m("ST", "Sao Tome and Principe", "STP", 222, 678);
        m mVar222 = new m("SU", "USSR", "SUN", 223, 810);
        m mVar223 = new m("SV", "El Salvador", "SLV", 224, 222);
        m mVar224 = new m("SX", "Sint Maarten (Dutch part)", "SXM", 225, 534);
        m mVar225 = new m("SY", "Syrian Arab Republic", "SYR", 226, 760);
        m mVar226 = new m("SZ", "Eswatini", "SWZ", 227, 748);
        m mVar227 = new m("TA", "Tristan da Cunha", "TAA", 228, -1);
        m mVar228 = new m("TC", "Turks and Caicos Islands", "TCA", 229, 796);
        m mVar229 = new m("TD", "Chad", "TCD", 230, 148);
        m mVar230 = new m("TF", "French Southern Territories", "ATF", 231, 260);
        m mVar231 = new m("TG", "Togo", "TGO", 232, 768);
        m mVar232 = new m("TH", "Thailand", "THA", 233, 764);
        m mVar233 = new m("TJ", "Tajikistan", "TJK", 234, 762);
        m mVar234 = new m("TK", "Tokelau", "TKL", 235, 772);
        m mVar235 = new m("TL", "Timor-Leste", "TLS", 236, 626);
        f4558v = mVar235;
        m mVar236 = new m("TM", "Turkmenistan", "TKM", 237, 795);
        m mVar237 = new m("TN", "Tunisia", "TUN", 238, 788);
        m mVar238 = new m("TO", "Tonga", "TON", 239, 776);
        m mVar239 = new m("TP", "East Timor", "TMP", 240, 626);
        f4559w = mVar239;
        m mVar240 = new m("TR", "Turkey", "TUR", 241, 792);
        m mVar241 = new m("TT", "Trinidad and Tobago", "TTO", 242, 780);
        m mVar242 = new m("TV", "Tuvalu", "TUV", 243, 798);
        m mVar243 = new m() { // from class: c3.a
        };
        m mVar244 = new m("TZ", "Tanzania, United Republic of", "TZA", 245, 834);
        m mVar245 = new m("UA", "Ukraine", "UKR", 246, 804);
        m mVar246 = new m("UG", "Uganda", "UGA", 247, 800);
        m mVar247 = new m() { // from class: c3.b
        };
        m mVar248 = new m("UM", "United States Minor Outlying Islands", "UMI", 249, 581);
        m mVar249 = new m() { // from class: c3.c
        };
        m mVar250 = new m("UY", "Uruguay", "URY", 251, 858);
        m mVar251 = new m("UZ", "Uzbekistan", "UZB", 252, 860);
        m mVar252 = new m("VA", "Holy See (Vatican City State)", "VAT", 253, 336);
        m mVar253 = new m("VC", "Saint Vincent and the Grenadines", "VCT", 254, 670);
        m mVar254 = new m("VE", "Venezuela, Bolivarian Republic of", "VEN", 255, 862);
        m mVar255 = new m("VG", "Virgin Islands, British", "VGB", PSKKeyManager.MAX_KEY_LENGTH_BYTES, 92);
        m mVar256 = new m("VI", "Virgin Islands, U.S.", "VIR", 257, 850);
        m mVar257 = new m("VN", "Viet Nam", "VNM", 258, 704);
        m mVar258 = new m("VU", "Vanuatu", "VUT", 259, 548);
        m mVar259 = new m("WF", "Wallis and Futuna", "WLF", 260, 876);
        m mVar260 = new m("WS", "Samoa", "WSM", 261, 882);
        m mVar261 = new m("XI", "Northern Ireland", "XXI", 262, -1);
        m mVar262 = new m("XU", "United Kingdom (excluding Northern Ireland)", "XXU", 263, -1);
        m mVar263 = new m("XK", "Kosovo, Republic of", "XKX", 264, -1);
        m mVar264 = new m("YE", "Yemen", "YEM", 265, 887);
        m mVar265 = new m("YT", "Mayotte", "MYT", 266, 175);
        m mVar266 = new m("YU", "Yugoslavia", "YUG", 267, 890);
        f4560x = mVar266;
        m mVar267 = new m("ZA", "South Africa", "ZAF", 268, 710);
        m mVar268 = new m("ZM", "Zambia", "ZMB", 269, 894);
        m mVar269 = new m("ZR", "Zaire", "ZAR", 270, 180);
        f4561y = mVar269;
        f4549C = new m[]{mVar, mVar2, mVar3, mVar4, mVar5, mVar6, mVar7, mVar8, mVar9, mVar10, mVar11, mVar12, mVar13, mVar14, mVar15, mVar16, mVar17, mVar18, mVar19, mVar20, mVar21, mVar22, mVar23, mVar24, mVar25, mVar26, mVar27, mVar28, mVar29, mVar30, mVar31, mVar32, mVar33, mVar34, mVar35, mVar36, mVar37, mVar38, mVar39, mVar40, mVar41, mVar42, mVar43, mVar44, mVar45, mVar46, mVar47, mVar48, mVar49, mVar50, mVar51, mVar52, mVar53, mVar54, mVar55, mVar56, mVar57, mVar58, mVar59, mVar60, mVar61, mVar62, r61, mVar63, mVar64, mVar65, mVar66, mVar67, mVar68, mVar69, mVar70, mVar71, mVar72, mVar73, mVar74, mVar75, mVar76, mVar77, mVar78, mVar79, mVar80, mVar81, mVar82, mVar83, mVar84, mVar85, mVar86, r86, mVar87, mVar88, mVar89, mVar90, mVar91, mVar92, mVar93, mVar94, mVar95, mVar96, mVar97, mVar98, mVar99, mVar100, mVar101, mVar102, mVar103, mVar104, mVar105, mVar106, mVar107, mVar108, mVar109, mVar110, mVar111, mVar112, mVar113, mVar114, mVar115, mVar116, mVar117, mVar118, mVar119, mVar120, mVar121, mVar122, mVar123, mVar124, mVar125, mVar126, mVar127, mVar128, mVar129, mVar130, mVar131, mVar132, mVar133, mVar134, mVar135, mVar136, mVar137, mVar138, mVar139, mVar140, mVar141, mVar142, mVar143, mVar144, mVar145, mVar146, mVar147, mVar148, mVar149, mVar150, mVar151, mVar152, mVar153, mVar154, mVar155, mVar156, mVar157, mVar158, mVar159, mVar160, mVar161, mVar162, mVar163, mVar164, mVar165, mVar166, mVar167, mVar168, mVar169, mVar170, mVar171, mVar172, mVar173, mVar174, mVar175, mVar176, mVar177, mVar178, mVar179, mVar180, mVar181, mVar182, mVar183, mVar184, mVar185, mVar186, mVar187, mVar188, mVar189, mVar190, mVar191, mVar192, mVar193, mVar194, mVar195, mVar196, mVar197, mVar198, mVar199, mVar200, mVar201, mVar202, mVar203, mVar204, mVar205, mVar206, mVar207, mVar208, mVar209, mVar210, mVar211, mVar212, mVar213, mVar214, mVar215, mVar216, mVar217, mVar218, mVar219, mVar220, mVar221, mVar222, mVar223, mVar224, mVar225, mVar226, mVar227, mVar228, mVar229, mVar230, mVar231, mVar232, mVar233, mVar234, mVar235, mVar236, mVar237, mVar238, mVar239, mVar240, mVar241, mVar242, mVar243, mVar244, mVar245, mVar246, mVar247, mVar248, mVar249, mVar250, mVar251, mVar252, mVar253, mVar254, mVar255, mVar256, mVar257, mVar258, mVar259, mVar260, mVar261, mVar262, mVar263, mVar264, mVar265, mVar266, mVar267, mVar268, mVar269, new m("ZW", "Zimbabwe", "ZWE", 271, 716)};
        f4562z = new HashMap();
        f4547A = new HashMap();
        f4548B = new HashMap();
        for (m mVar270 : values()) {
            String str = mVar270.f4564k;
            if (str != null) {
                f4562z.put(str, mVar270);
            }
            int i5 = mVar270.f4565l;
            if (i5 != -1) {
                f4548B.put(Integer.valueOf(i5), mVar270);
            }
        }
        HashMap map = f4562z;
        m mVar271 = f4554r;
        map.put("FIN", mVar271);
        HashMap map2 = f4547A;
        map2.put("ANHH", f4550m);
        map2.put("BUMM", n);
        map2.put("CSXX", f4552p);
        map2.put("NTHH", f4557u);
        map2.put("TPTL", f4559w);
        map2.put("YUCS", f4560x);
        map2.put("ZRCD", f4561y);
        HashMap map3 = f4548B;
        map3.put(104, f4556t);
        map3.put(180, f4551o);
        map3.put(246, mVar271);
        map3.put(826, f4555s);
        map3.put(626, f4558v);
        map3.put(280, f4553q);
    }

    public m(String str, String str2, String str3, int i5, int i6) {
        this.f4563j = str2;
        this.f4564k = str3;
        this.f4565l = i6;
    }

    public static ArrayList a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("regex is null.");
        }
        Pattern patternCompile = Pattern.compile(str);
        if (patternCompile == null) {
            throw new IllegalArgumentException("pattern is null.");
        }
        ArrayList arrayList = new ArrayList();
        for (m mVar : values()) {
            if (patternCompile.matcher(mVar.f4563j).matches()) {
                arrayList.add(mVar);
            }
        }
        return arrayList;
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f4549C.clone();
    }
}
