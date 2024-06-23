package com.boliver.datavisualiser_thewebscrappingtool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class KRT_Activity extends AppCompatActivity {
    // URL Address
    //String url = "https://www.google.com";
    public ProgressDialog mProgressDialog;

    public boolean bool_sutxt1, bool_sutxt2, bool_sutxt3, bool_sutxt4, bool_sutxt5, bool_sutxt6, bool_sutxt7, bool_sutxt8, bool_sutxt9, bool_sutxt10, bool_sutxt11, bool_sutxt12, bool_sutxt13, bool_sutxt14, bool_sutxt15, bool_sutxt16, bool_sutxt17, bool_sutxt18, bool_sutxt19;
    public TextView tgnm1, tgnm2, tgnm3, tgnm4, tgnm5, tgnm6, tgnm7, tgnm8, tgnm9, tgnm10, tgnm11, tgnm12, tgnm13, tgnm14, tgnm15, tgnm16, tgnm17, tgnm18, tgnm19;
    public TextView tvBody1, tvBody2, tvBody3, tvBody4, tvBody5, tvBody6, tvBody7, tvBody8, tvBody9, tvBody10, tvBody11, tvBody12, tvBody13, tvBody14, tvBody15, tvBody16, tvBody17, tvBody18, tvBody19;
    public TextView rntxt1, rntxt2, rntxt3, rntxt4, rntxt5, rntxt6, rntxt7, rntxt8, rntxt9, rntxt10, rntxt11, rntxt12, rntxt13, rntxt14, rntxt15, rntxt16, rntxt17, rntxt18, rntxt19;
    public TextView sutxt1, sutxt2, sutxt3, sutxt4, sutxt5, sutxt6, sutxt7, sutxt8, sutxt9, sutxt10, sutxt11, sutxt12, sutxt13, sutxt14, sutxt15, sutxt16, sutxt17, sutxt18, sutxt19;
    public TextView su1, su2, su3, su4, su5, su6, su7, su8, su9, su10, su11, su12, su13, su14, su15, su16, su17, su18, su19;
    public ScrollView childScroll;
    public NestedScrollView parentScroll;
    public ConstraintLayout searchNow_cl;
    public EditText et_enter_url;

    //1. URL, HTML
    public int no_of_subDirectories_inURL;
    public String surl_subDomain, surl_protocol, surl_rootDomain, surl_topLevelDomain;
    public String[] surl_sd_a = new String[500];
    public String ip_address_str;
    public String surl, surl_report, string_url_editText;
    public boolean url_valid_on_bool, website_secured_on_bool;
    public int key_pos;
    public char keyLastSecond;
    public int no_of_dots;
    public String html_string;
    public ConstraintLayout url_cl1, htmlsourcecode_cl1, title_cl1, headers_cl1, body_cl1, links_cl1, images_cl1, keywords_cl1, pagefavicon_cl1, ipaddress_cl1, pageloadtime_cl1, index_factors_cl1, pageranknctr_cl1;

    //2. TITLE
    public int title_char_count, title_word_count, title_ws_count;
    public String title_string, title_report;
    public String[] title_keywords_a = new String[500];

    //3. HEADERS
    public boolean h1_bool, h2_bool, h3_bool, h4_bool, h5_bool, h6_bool;
    public String[] h1_total_a = new String[500];
    public String[] h2_total_a = new String[500];
    public String[] h3_total_a = new String[500];
    public String[] h4_total_a = new String[500];
    public String[] h5_total_a = new String[500];
    public String[] h6_total_a = new String[500];
    public String[] headers_keywords_total_ = new String[2000];
    public int h1_twords, h2_twords, h3_twords, h4_twords, h5_twords, h6_twords;
    public int h1_tws, h2_tws, h3_tws, h4_tws, h5_tws, h6_tws;//white spaces
    public int h1_char_count, h2_char_count, h3_char_count, h4_char_count, h5_char_count, h6_char_count;
    public String headers_report_h1_h6;
    public String h1_report, h2_report, h3_report, h4_report, h5_report, h6_report;
    public String h1_string, h2_string, h3_string, h4_string, h5_string, h6_string;
    public String h1_string_ftc, h2_string_ftc, h3_string_ftc, h4_string_ftc, h5_string_ftc, h6_string_ftc;
    public int h1_size, h2_size, h3_size, h4_size, h5_size, h6_size;

    //4. BODY tag
    public int p_tags_size, div_tags_size, h1_tags_size, h2_tags_size, h3_tags_size, h4_tags_size, h5_tags_size, h6_tags_size, img_tags_size, href_tags_size, meta_description_tags_size, meta_keywords_size, meta_author_size, meta_robots_size, meta_view_port_size, link_rel_canonical_tag_size;
    public String body_report;
    public boolean p_tags_bool, div_tags_bool, h1_tags_bool, h2_tags_bool, h3_tags_bool, h4_tags_bool, h5_tags_bool, h6_tags_bool, img_tags_bool, href_tags_bool, meta_description_tags_bool, meta_author_bool, meta_keywords_bool, meta_robots_bool, meta_view_port_bool, link_rel_canonical_tag_bool;
    public String meta_keywords_string, meta_author_string, meta_description_string, meta_viewport_string, rel_canonical;
    public int meta__tags_total;

    //5. LINKS Tag
    public boolean links_bool;
    public int links_count, link_text_count_size_numbers;
    public String[] highlighted_text_str_a = new String[2000];
    public String[] highlightedLink_str_a = new String[2000];
    public String href_strings_report;

    //6. IMAGES Tag
    public boolean image_bool;
    public boolean[] img_alt_bool = new boolean[500];
    public String[] img_alt_value = new String[500];
    public String[] img_res_value = new String[500];
    public String[] img_linksrc_value = new String[500];
    public String img_report_string;
    public int img_count_size, img_alt_count_size; //refers to alt count

    //7,8, KEYWORDS    ( 7 is for URL n HTML combined )
    public int total_keywords_count;// =  img_alt_count_size + links_count + h1_twords + h2_twords + h3_twords + h4_twords + h5_twords+ h6_twords + title_word_count
    public String[] total_keywords_a = new String[500];  //image_alt_value[i] + highlighted_text_str_a[i] + title_keywords_a[i] + h1_total_a[i] + h2_total_a[i] + h3_total_a[i] + h4_total_a[i] + h5_total_a[i] + h6_total_a[i];
    public String keywords_report;

    //9, 11, 12, 13, 14
    // public String meta_keywords_string, meta_author_string, meta_description_string, meta_viewport_string, rel_canonical;
    //public boolean meta_description_tags_bool, meta_author_bool, meta_keywords_bool, meta_robots_bool, meta_view_port_bool, link_rel_canonical_tag_bool;
    //public int meta_description_tags_size, meta_keywords_size, meta_author_size, meta_robots_size, meta_view_port_size, link_rel_canonical_tag_size;
    public String page_favicon_report, meta_robots_string, rel_canonical_report_string;
    public String meta_robots_report, meta_keywords_report, meta_author_report, meta_description_report, meta_viewport_report, rel_canonical_report;
    public TextView textView_on_no_report_page;
    public ConstraintLayout full_report_website_SEO;
    public int i ;

    //update 1 features || Variables Added
    public boolean url_valid_bool_real ;

    ConstraintLayout recentsCL;
    ImageView top_arrow_recents_iv, bottom_arrow_recents_iv;
    ConstraintLayout links_CL;
    public ListView links_LV;
    public boolean recents_bool;

    public String[] str_arr_links = new String[1000];
    //public char s

    int int_str_total_links_length;
    int in_arr_count;
    char[] char_total_links;
    TextView textView;

    String space_plus_url;
    ConstraintLayout constraint_layout_full_report;
    NestedScrollView parentScroll2, parentScroll3;
    ScrollView childScroll2, childScroll3;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krt);



        surl_report = "";surl = "";
        constraint_layout_full_report=findViewById(R.id.constraint_layout_full_report);
        textView_on_no_report_page=findViewById(R.id.textView_when_the_report_page_is_invisible);
        i=0;full_report_website_SEO=findViewById(R.id.constraint_layout_full_report);
        searchNow_cl = findViewById(R.id.searchURL);
        getSupportActionBar().hide();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        url_valid_bool_real=false;
        recents_bool=false;
//        textView=findViewById(R.id.textView);
        for(int i = 0; i<1000; ++i){
            str_arr_links[i]="";
        }

/*
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Name","Harneet");
        editor.apply();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preferences.getString("Name", "");
*/

//recents
        constraint_layout_full_report.setVisibility(View.GONE);
        recentsCL = findViewById(R.id.recents_cl);
        top_arrow_recents_iv = findViewById(R.id.topIV_rec);
        bottom_arrow_recents_iv=findViewById(R.id.bottomIV_rec);
        links_CL = findViewById(R.id.links_CL);
        links_LV=findViewById(R.id.links_LV);

        links_CL.setVisibility(View.GONE);
        top_arrow_recents_iv.setVisibility(View.GONE);
        bottom_arrow_recents_iv.setVisibility(View.VISIBLE);
        recentsCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recents_bool==true){
                    recents_bool=false;
                    links_CL.setVisibility(View.GONE);
                    bottom_arrow_recents_iv.setVisibility(View.VISIBLE);
                    top_arrow_recents_iv.setVisibility(View.INVISIBLE);
                }else
                {
                    links_LV.setAdapter(null);


                    recents_bool = true;
                    bottom_arrow_recents_iv.setVisibility(View.INVISIBLE);
                    top_arrow_recents_iv.setVisibility(View.VISIBLE);
                    links_CL.setVisibility(View.VISIBLE);

                    ArrayList list;
                    ArrayAdapter adapter;
                    //for(int i =0)
                    String str_total_links = preferences.getString("SPtotalLinks_str", "");
                    char_total_links = str_total_links.toCharArray();
                    int_str_total_links_length=char_total_links.length;
                    //for Loop
                    for(int i=0;i<int_str_total_links_length;++i){
                        if(char_total_links[i]!=' '){
                            str_arr_links[in_arr_count]+=char_total_links[i];
                        }else{
                            in_arr_count+=1;
                        }
                    }//end of for loop
                    list = new ArrayList<>();

                    for(int i=in_arr_count-1; i>=0;--i){
                        list.add(str_arr_links[i]);
                    }
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
                    links_LV.setAdapter(adapter);
                }
            }
        });

//Search Now
        searchNow_cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                full_report_website_SEO.setVisibility(View.GONE);
                surl = et_enter_url.getText().toString();
                textView_on_no_report_page.setVisibility(View.VISIBLE);
                new Content().execute();
                Toast.makeText(getApplicationContext(), "please wait ..", Toast.LENGTH_SHORT).show();
*/
                if(url_valid_bool_real){

                    full_report_website_SEO.setVisibility(View.GONE);
                    surl = et_enter_url.getText().toString();
                    constraint_layout_full_report.setVisibility(View.VISIBLE);
                    textView_on_no_report_page.setVisibility(View.VISIBLE);
                    new Content().execute();
                    Toast.makeText(getApplicationContext(), "please wait ..", Toast.LENGTH_SHORT).show();
                    links_LV.setAdapter(null);

                    ArrayList list;
                    ArrayAdapter adapter;
                    String str_prev_total = preferences.getString("SPtotalLinks_str", "");

                    space_plus_url = str_prev_total+" "+surl;
                    editor.putString("SPtotalLinks_str",space_plus_url);
                    editor.apply();

                    //ListView insertion
                    String str_total_links = preferences.getString("SPtotalLinks_str", "");
                    char_total_links = str_total_links.toCharArray();
                    int_str_total_links_length=char_total_links.length;
                    //for Loop
                    for(int i=0;i<int_str_total_links_length;++i){
                        if(char_total_links[i]!=' '){
                            str_arr_links[in_arr_count]+=char_total_links[i];
                        }else{
                            in_arr_count+=1;
                        }
                    }//end of for loop
                    list = new ArrayList<>();

                    for(int i=in_arr_count-1; i>=0;--i){
                        list.add(str_arr_links[i]);
                    }
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
                    links_LV.setAdapter(adapter);

                }else{
                    full_report_website_SEO.setVisibility(View.GONE);
                    surl = et_enter_url.getText().toString();
                    textView_on_no_report_page.setVisibility(View.VISIBLE);
                    new Content().execute();
                    Toast.makeText(getApplicationContext(), "please wait ..", Toast.LENGTH_SHORT).show();
                }
            }
        });

//ListView insertion
        links_LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                // TODO Auto-generated method stub
                /* appending Happy with festival name */
                String value = (links_LV.getItemAtPosition(position)).toString();
                /* Display the Toast */
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
                surl=value;
                new Content().execute();
                Toast.makeText(getApplicationContext(), "please wait ..", Toast.LENGTH_SHORT).show();
            }
        });
//Ends ListView Insertion



        url_cl1 = findViewById(R.id.url_cl);
        htmlsourcecode_cl1 = findViewById(R.id.htmlsourcecode_cl);
        et_enter_url = findViewById(R.id.et_enterUrl);


//        et_enter_url = findViewById(R.id.et_enterUrl);
        tgnm1 = findViewById(R.id.tgnm1);
        tgnm2 = findViewById(R.id.tgnm2);
        tgnm3 = findViewById(R.id.tgnm3);
        tgnm4 = findViewById(R.id.tgnm4);
        tgnm5 = findViewById(R.id.tgnm5);
        tgnm6 = findViewById(R.id.tgnm6);
        tgnm7 = findViewById(R.id.tgnm7);
        tgnm8 = findViewById(R.id.tgnm8);
        tgnm9= findViewById(R.id.tgnm9);

        tgnm14= findViewById(R.id.tgnm14);
        tgnm15= findViewById(R.id.tgnm15);
        tgnm16= findViewById(R.id.tgnm16);
        tgnm17= findViewById(R.id.tgnm17);
        tgnm18 = findViewById(R.id.tgnm18);
        tgnm19 =findViewById(R.id.tgnm19);






        tvBody1 = findViewById(R.id.tvBody1);
        tvBody2 = findViewById(R.id.tvBody2);
        tvBody3 = findViewById(R.id.tvBody3);
        tvBody4 = findViewById(R.id.tvBody4);
        tvBody5 = findViewById(R.id.tvBody5);
        tvBody6 = findViewById(R.id.tvBody6);
        tvBody7 = findViewById(R.id.tvBody7);
        tvBody8 = findViewById(R.id.tvBody8);
        tvBody9= findViewById(R.id.tvBody9);

        tvBody14= findViewById(R.id.tvBody14);
        tvBody15= findViewById(R.id.tvBody15);
        tvBody16= findViewById(R.id.tvBody16);
        tvBody17= findViewById(R.id.tvBody17);
        tvBody18 = findViewById(R.id.tvBody18);
        tvBody19 = findViewById(R.id.tvBody19);




        textView_on_no_report_page.setVisibility(View.VISIBLE);

//        string_url_editText = et_enter_url.getText().toString();
//        surl = string_url_editText;
//        searchNow_cl = findViewById(R.id.searchNow_tv_iv);
//        url_char_count = 0;
//        url_word_count = 0;
//        url_ws_count = 0;
//        no_of_slashes_inURL = 0;
//        no_of_subDirectories_inURL = 0;
//        sd_pos_fs = 0;
//        TextView textView=findViewById(R.id.textView_enterUrl_onScrollView_different);

        //      textView.setVisibility(View.VISIBLE);


//        surl="";
//         surl=et_enter_url.getText().toString();

        surl="";
        surl = et_enter_url.getText().toString();

//1
        childScroll = findViewById(R.id.child_scrollview);
        parentScroll = findViewById(R.id.nscv1);
        parentScroll.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.child_scrollview).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        childScroll.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

//2
        childScroll2 = findViewById(R.id.parentscrollview2);
        parentScroll2 = findViewById(R.id.nscv1);
        parentScroll2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.parentscrollview2).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        childScroll2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

//3
        childScroll3 = findViewById(R.id.parentscv3);
        parentScroll3 = findViewById(R.id.nscv1);
        parentScroll3.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.parentscv3).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        childScroll3.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

//        tvBody1.setText(surl_report);
//        tvBody1.setText(surl_report);


    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Intent intent = new Intent(KRT_Activity.this, MainActivity.class);
        startActivity(intent);
    }




    private class Content extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(KRT_Activity.this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {


            //URL section
            //HTML source code section
            surl = surl.trim();

            for (int i = 0; i < 500; ++i) {
                surl_sd_a[i] = "";
                title_keywords_a[i] = "";
                h1_total_a[i] = "";
                h2_total_a[i] = "";
                h3_total_a[i] = "";
                h4_total_a[i] = "";
                h5_total_a[i] = "";
                h6_total_a[i] = "";
                img_alt_value[i] = "";
                img_res_value[i] = "";
                img_linksrc_value[i] = "";
                img_alt_bool[i] = false;
            }
            for (int i = 0; i < 2000; ++i) {
                highlighted_text_str_a[i] = "";
                highlightedLink_str_a[i] = "";
            }
            html_string = "";//2
            keywords_report = "";//8
            page_favicon_report = "";//9 , desc, robots, viewport, rel canonical link tag, author
            body_report = "";//5
            href_strings_report = "";//6
            url_valid_on_bool = false;
            website_secured_on_bool = false;
            key_pos = 0;
            no_of_dots = 0;
            keyLastSecond = 'a';


            h1_report = "";
            h2_report = "";
            h3_report = "";
            h4_report = "";
            h5_report = "";
            h6_report = "";
            surl_report = "";
            string_url_editText = "";

            title_string = "";
            h1_bool = false;
            h2_bool = false;
            h3_bool = false;
            h4_bool = false;
            h5_bool = false;
            h6_bool = false;
            h1_twords = 0;
            h2_twords = 0;
            h3_twords = 0;
            h4_twords = 0;
            h5_twords = 0;
            h6_twords = 0;
            h1_tws = 0;
            h1_size = 0;
            p_tags_size = 0;
            h2_tws = 0;
            h2_size = 0;
            h1_tags_size = 0;
            h3_tws = 0;
            h3_size = 0;
            h2_tags_size = 0;
            h4_tws = 0;
            h4_size = 0;
            h3_tags_size = 0;
            h5_tws = 0;
            h5_size = 0;
            h4_tags_size = 0;
            img_tags_size = 0;
            h6_tws = 0;
            h6_size = 0;
            h5_tags_size = 0;
            h6_tags_size = 0;
            h1_char_count = 0;
            h1_string = "";
            h1_string_ftc = "";
            h2_char_count = 0;
            h2_string = "";
            h2_string_ftc = "";
            h3_char_count = 0;
            h3_string = "";
            h3_string_ftc = "";
            h4_char_count = 0;
            h4_string = "";
            h4_string_ftc = "";
            h5_char_count = 0;
            h5_string = "";
            h5_string_ftc = "";
            h6_char_count = 0;
            h6_string = "";
            h6_string_ftc = "";
            headers_report_h1_h6 = "";
            total_keywords_count = 0;


            img_count_size = 0;
            img_alt_count_size = 0;

            title_report = "";//3
            img_report_string = "";//7
            headers_report_h1_h6 = "";//4
            meta_description_string = ""; //14
            meta_robots_string = ""; //15
            meta_keywords_string = "";//19
            meta_author_string = "";//18
            meta_viewport_string = ""; //16
            rel_canonical_report = "";
            rel_canonical = "";
            meta__tags_total = 0;
            link_text_count_size_numbers = 0;
            links_count = 0;
            keywords_report = "";

            rel_canonical_report_string = "";//17
            page_favicon_report = "";
            ip_address_str = "";

            meta_description_tags_size = 0;
            meta_robots_size = 0;
            meta_view_port_size = 0;
            link_rel_canonical_tag_size = 0;
            meta_author_size = 0;
            meta_keywords_size = 0;

            int url_char_count = 0;
            int url_word_count = 0;
            int url_ws_count = 0;
            int no_of_slashes_inURL = 0;
            int sd_pos_fs = 0;

            surl_protocol = "";
            surl_subDomain = "";
            surl_rootDomain = "";
            surl_topLevelDomain = "";

            no_of_subDirectories_inURL = 0;
            char[] ch_array_url = surl.toCharArray();
            url_char_count = surl.length();

            if (url_char_count == 0) {
                url_valid_on_bool = false;
            }
            //* no. of slashes
            for (int i = 0; i < url_char_count; ++i) {
                if (ch_array_url[i] == '/') {
                    no_of_slashes_inURL += 1;
                }
            }
            //2.5. URL is secured or not:   contains "s" or not
            if (ch_array_url[4] == 's') {
                website_secured_on_bool = true;
                surl_protocol = "https://";
                sd_pos_fs = 8;
            } else {
                website_secured_on_bool = false;
                surl_protocol = "http://";
                sd_pos_fs = 7;
            }
            //3. url valid or not
            no_of_dots = 0;
            if (url_char_count <= 9) {
                url_valid_on_bool = false;
            } else {
                for (int i = 0; i < url_char_count; ++i) {
                    if (ch_array_url[i] == '.') {
                        no_of_dots += 1;
                    }
                }
                if (no_of_dots <= 0) {
                    url_valid_on_bool = false;
                } else {
                    if (ch_array_url[0] != 'h') {
                        url_valid_on_bool = false;
                    } else {
                        url_valid_on_bool = true;
                    }
                }

            }


//Website URL
            if (url_valid_on_bool == true) {
//4. subDomain
                boolean h = false;
                while (sd_pos_fs != url_char_count) {
                    if (ch_array_url[sd_pos_fs] != '.') {
                        surl_subDomain += ch_array_url[sd_pos_fs];
                    } else {
                        surl_subDomain += ch_array_url[sd_pos_fs];
                        break;
                    }
                    sd_pos_fs += 1;
                }
                sd_pos_fs += 1;
//5. root Domain
                while (sd_pos_fs != url_char_count) {
                    if (no_of_dots >= 2) {
                        if (ch_array_url[sd_pos_fs] != '.') {
                            surl_rootDomain += ch_array_url[sd_pos_fs];
                        } else {
                            surl_rootDomain += ch_array_url[sd_pos_fs];
                            break;
                        }
                    }
                    if (no_of_dots == 1) {
                        if (ch_array_url[sd_pos_fs] != '/') {
                            surl_rootDomain += ch_array_url[sd_pos_fs];
                        } else {
                            surl_rootDomain += ch_array_url[sd_pos_fs];
                            break;
                        }
                    }


                    sd_pos_fs += 1;
                }
//6. top level domain
                key_pos = 0;
                while (sd_pos_fs != url_char_count) {
                    if (ch_array_url[sd_pos_fs] != '/') {
                        surl_topLevelDomain += ch_array_url[sd_pos_fs];
                    } else {
                        surl_topLevelDomain += ch_array_url[sd_pos_fs];

                        keyLastSecond = ch_array_url[(sd_pos_fs - 1)];
                        if (sd_pos_fs + 1 <= url_char_count) {
                            key_pos = sd_pos_fs + 1;
                        }

                        break;
                    }
                    sd_pos_fs += 1;

                }
//7. categories, or subdirectories, or surl_sd_a[20]
                int k = 0;
                boolean hit_second_dot_q = false;
                for (int i = 0; i < url_char_count; ++i) {
                    if (ch_array_url[i] == '.') {
                        k = k + 1;
                        if (k == 2) {
                            hit_second_dot_q = true;
                        }
                    }
                    if (hit_second_dot_q == true) {
                        if (ch_array_url[i] == '/') {
                            key_pos = i + 1;
                            break;
                        }
                    }
                }
                //* no of sub directories
                if (ch_array_url[url_char_count - 1] == '/') {
                    char st = ch_array_url[url_char_count - 2];
                    if (keyLastSecond == st) {
                        no_of_subDirectories_inURL = 0;
                    } else {
                        no_of_subDirectories_inURL = no_of_slashes_inURL - 3;
                    }

                } else {
                    char st = ch_array_url[url_char_count - 2];
                    if (keyLastSecond == st) {
                        no_of_subDirectories_inURL = 0;
                    } else {
                        no_of_subDirectories_inURL = no_of_slashes_inURL - 2;
                    }
                }
                //start subDirectories code
                int i = 0;
                boolean jump_directory_bool = false;
                if (key_pos != 0) {
                    while (key_pos < url_char_count) {
                        if (ch_array_url[key_pos] != '/') {
                            surl_sd_a[i] += ch_array_url[key_pos];
                        } else {
                            surl_sd_a[i] += ch_array_url[key_pos];
                            i = i + 1;
                            if ((i - 1) == no_of_subDirectories_inURL - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }
                }
            }
            if (url_valid_on_bool == false) {
                surl_report = "1. URL is invalid. Try removing spaces from both the Ends of the URL. \n\n";
            } else {
                surl_report = "URL:\n---------------------------------------------------------------------------------------------\n" + surl + "\n---------------------------------------------------------------------------------------------\n\n1. URL structure is valid\n\n";
                if (website_secured_on_bool == false) {
                    surl_report = surl_report + "2. Site is not secured. Uses \"http\" in place of \"http\" as a scheme. \n\n";
                } else {
                    surl_report = surl_report + "2. Site is secured. Uses \"https\" as a scheme. \n\n";
                }
                surl_report = surl_report + "3. Site Architecture:\n\t- SCHEME: \t\t" + surl_protocol + "\n\t- SUB-DOMAIN: \t\t" + surl_subDomain + "\n\t- ROOT-DOMAIN: \t\t" + surl_rootDomain + "\n\t- TOP LEVEL-DOMAIN: \t\t" + surl_topLevelDomain;
                if (no_of_subDirectories_inURL == 0) {
                    surl_report = surl_report + "\n\n\t- Sub Directory(s): UNAVAILABLE !\n";
                } else {
                    surl_report = surl_report + "\n\n\t- Sub Directory(s): AVAILABLE !\n";
                    surl_report = surl_report + "\n\n\t- Sub Directories:-\t Counts to " + no_of_subDirectories_inURL + " in numbers";

                    for (int k = 0; k < no_of_subDirectories_inURL; ++k) {
                        surl_report = surl_report + "\n\t- SubDirectory_" + (k + 1) + ":\t " + surl_sd_a[k];
                    }
                }
                surl_report = surl_report + "\n\n4. URL/Site IP Address: " + ip_address_str;

            }

            if (url_valid_on_bool == true) {
                try {
                    html_string = Jsoup.connect(surl).get().html();
                    url_valid_bool_real = true;
                    if (html_string == "") {
                        url_valid_on_bool = false;
                        url_valid_bool_real = false;
                    }
                } catch (IOException e) {
                    html_string = "Copy paste the Full URL. \nYou can use this tool as an enhancer in your SEO process. \nThis Application's Algorithm knows what you're up to.\n\nThe previous URL analysis was designed to interest you.\nThis HTML analysis section will tell the truth whether the URL is valid or not, that you can't really extract a HTML source code of a site/page with a \"not-so working\" URL.";
                    url_valid_on_bool = false;
                    url_valid_bool_real = false;
                }
            }

//Title Section
            title_ws_count = 0;
            title_char_count = 0;
            title_word_count = 0;
            if (url_valid_on_bool == true) {
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                title_string = document.title();
                char[] ch_array_title = title_string.toCharArray();
                title_char_count = title_string.length();
                for (int i = 0; i < title_char_count; ++i) {
                    if (ch_array_title[i] == ' ') {
                        title_ws_count += 1;
                    }
                }
                if (ch_array_title[0] == ' ') {

                    if (ch_array_title[title_char_count - 1] == ' ') {
                        if (title_ws_count == 2) {
                            title_word_count = 1;
                        }
                        if (title_ws_count > 2) {
                            title_word_count = title_ws_count - 1;
                        }
                    } else {
                        if (title_ws_count == 1) {
                            title_word_count = 1;
                        }
                        if (title_ws_count > 1) {
                            title_word_count = title_ws_count;
                        }
                    }
                } else {
                    if (ch_array_title[title_char_count - 1] == ' ') {
                        if (title_ws_count == 1) {
                            title_word_count = 1;
                        }
                        if (title_ws_count > 1) {
                            title_word_count = title_ws_count;
                        }
                    } else {
                        if (title_ws_count == 0) {
                            title_word_count = 1;
                        }
                        if (title_ws_count > 0) {
                            title_word_count = title_ws_count + 1;
                        }
                    }
                }

                title_report = "";
                title_report = "Title: " + title_string + "\n\n1. Length:\n\t\t- " + title_char_count + " Characters\n\t\t- or, " + title_word_count + " words & " + title_ws_count + " whitespaces\n\n2. Keywords:";

                //Sub directories code
                //start subDirectories code
                //key_pos code
                int hello;
                for (int i = 0; i < title_char_count; ++i) {
                    if (ch_array_title[i] != ' ') {
                        key_pos = i;
                        hello = i;
                        break;
                    }
                }
                title_keywords_a[0] = "";
                title_keywords_a[1] = "";
                title_keywords_a[2] = "";
                title_keywords_a[3] = "";
                title_keywords_a[4] = "";
                title_keywords_a[5] = "";
                title_keywords_a[6] = "";
                title_keywords_a[7] = "";
                title_keywords_a[8] = "";
                title_keywords_a[9] = "";
                title_keywords_a[10] = "";
                title_keywords_a[11] = "";
                title_keywords_a[12] = "";
                title_keywords_a[13] = "";
                title_keywords_a[14] = "";
                title_keywords_a[15] = "";
                title_keywords_a[16] = "";
                title_keywords_a[17] = "";
                title_keywords_a[18] = "";
                title_keywords_a[19] = "";
                title_keywords_a[20] = "";


                int i = 0;
                boolean jump_directory_bool = false;
                while (key_pos < title_char_count) {
                    if (ch_array_title[key_pos] != ' ') {
                        title_keywords_a[i] += ch_array_title[key_pos];
                    } else {
                        title_keywords_a[i] += ch_array_title[key_pos];
                        i = i + 1;
                        if ((i - 1) == title_word_count - 1) {
                            jump_directory_bool = true;
                        }

                    }
                    key_pos += 1;
                    if (jump_directory_bool == true) {
                        break;
                    }
                }
                for (int j = 0; j < title_word_count; ++j) {
                    title_report = title_report + "\n\t\t- " + title_keywords_a[j];
                }


            }

//HEADERS Section
            if (url_valid_on_bool == true) {
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                h1_size = document.getElementsByTag("h1").size();
                h2_size = document.getElementsByTag("h2").size();
                h3_size = document.getElementsByTag("h3").size();
                h4_size = document.getElementsByTag("h4").size();
                h5_size = document.getElementsByTag("h5").size();
                h6_size = document.getElementsByTag("h6").size();

                if (h1_size == 0) {
                    h1_bool = false;//not available
                } else {
                    h1_bool = true;
                }
                if (h2_size == 0) {
                    h2_bool = false;//not available
                } else {
                    h2_bool = true;
                }
                if (h3_size == 0) {
                    h3_bool = false;//not available
                } else {
                    h3_bool = true;
                }
                if (h4_size == 0) {
                    h4_bool = false;//not available
                } else {
                    h4_bool = true;
                }
                if (h5_size == 0) {
                    h5_bool = false;//not available
                } else {
                    h5_bool = true;
                }
                if (h6_size == 0) {
                    h6_bool = false;//not available
                } else {
                    h6_bool = true;
                }
                h1_string = "";
                h2_string = "";
                h3_string = "";
                h4_string = "";
                h5_string = "";
                h6_string = "";

                h1_string_ftc = "";
                h2_string_ftc = "";
                h3_string_ftc = "";
                h4_string_ftc = "";
                h5_string_ftc = "";
                h6_string_ftc = "";

                h1_tws = 0;
                h2_tws = 0;
                h3_tws = 0;
                h4_tws = 0;
                h5_tws = 0;
                h6_tws = 0;

                Elements hTags = document.select("h1, h2, h3, h4, h5, h6");


                //group of all h1 tags
                if (h1_bool == true) {


                    Elements h1Tags = hTags.select("h1");
                    int i = 0;
                    for (Element h1Tag : h1Tags) {
                        i = i + 1;
                        h1_string = h1_string + "\n\t" + i + ". " + h1Tag.text();
                        h1_string_ftc = h1_string_ftc + h1Tag.text();
                    }
                    //fetch the h1_char_count, h1_word_count, h1_ws_count
                    char[] ch_array_h1 = h1_string_ftc.toCharArray();
                    h1_char_count = h1_string_ftc.length();

                    //white space count for h1
                    for (int o = 0; o < h1_char_count; ++o) {
                        if (ch_array_h1[o] == ' ') {
                            h1_tws += 1;
                        }
                    }
                    //words count for h1
                    if (ch_array_h1[0] == ' ') {

                        if (ch_array_h1[h1_char_count - 1] == ' ') {
                            if (h1_tws == 2) {

                                h1_twords = 1;
                            }
                            if (h1_tws > 2) {
                                h1_twords = h1_tws - 1;
                            }
                        } else {
                            if (h1_tws == 1) {
                                h1_twords = 1;
                            }
                            if (h1_tws > 1) {
                                h1_twords = h1_tws;
                            }
                        }
                    } else {
                        if (ch_array_h1[h1_char_count - 1] == ' ') {
                            if (h1_tws == 1) {
                                h1_twords = 1;
                            }
                            if (h1_tws > 1) {
                                h1_twords = h1_tws;
                            }
                        } else {
                            if (h1_tws == 0) {
                                h1_twords = 1;
                            }
                            if (h1_tws > 0) {
                                h1_twords = h1_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h1[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h1_char_count) {
                        if (ch_array_h1[key_pos] != ' ') {
                            h1_total_a[i] += ch_array_h1[key_pos];
                        } else {
                            h1_total_a[i] += ch_array_h1[key_pos];
                            i = i + 1;
                            if ((i - 1) == h1_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h1 report
                    h1_report = "";
                    h1_report += "h1 Summary:\n\n" + "There are " + h1_size + " h1 headers. Each of them are provided below.";
                    h1_report = h1_report + h1_string + "\n\n1. LENGTH: \n\t\t- " + h1_char_count + " characters\n\t\t- or, " + h1_twords + " keywords & " + h1_tws + " whitespace(s).";
                    h1_report = h1_report + "\n\n2. h1 KEYWORDS:";
                    for (i = 0; i < h1_twords; ++i) {
                        h1_report = h1_report + "\n\t\t- " + h1_total_a[i];
                    }


                }
                //group of all h2 tags
                if (h2_bool == true) {


                    Elements h2Tags = hTags.select("h2");
                    int i = 0;
                    for (Element h2Tag : h2Tags) {
                        i = i + 1;
                        h2_string = h2_string + "\n\t" + i + ". " + h2Tag.text();
                        h2_string_ftc = h2_string_ftc + h2Tag.text();
                    }
                    //fetch the h2_char_count, h2_word_count, h2_ws_count
                    char[] ch_array_h2 = h2_string_ftc.toCharArray();
                    h2_char_count = h2_string_ftc.length();

                    //white space count for h2
                    for (int o = 0; o < h2_char_count; ++o) {
                        if (ch_array_h2[o] == ' ') {
                            h2_tws += 1;
                        }
                    }
                    //words count for h2
                    if (ch_array_h2[0] == ' ') {

                        if (ch_array_h2[h2_char_count - 1] == ' ') {
                            if (h2_tws == 2) {

                                h2_twords = 1;
                            }
                            if (h2_tws > 2) {
                                h2_twords = h2_tws - 1;
                            }
                        } else {
                            if (h2_tws == 1) {
                                h2_twords = 1;
                            }
                            if (h2_tws > 1) {
                                h2_twords = h2_tws;
                            }
                        }
                    } else {
                        if (ch_array_h2[h2_char_count - 1] == ' ') {
                            if (h2_tws == 1) {
                                h2_twords = 1;
                            }
                            if (h2_tws > 1) {
                                h2_twords = h2_tws;
                            }
                        } else {
                            if (h2_tws == 0) {
                                h2_twords = 1;
                            }
                            if (h2_tws > 0) {
                                h2_twords = h2_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h2[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h2_char_count) {
                        if (ch_array_h2[key_pos] != ' ') {
                            h2_total_a[i] += ch_array_h2[key_pos];
                        } else {
                            h2_total_a[i] += ch_array_h2[key_pos];
                            i = i + 1;
                            if ((i - 1) == h2_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h2 report
                    h2_report = "";
                    h2_report += "h2 Summary:\n\n" + "There are " + h2_size + " h2 headers. Each of them are provided below.";
                    h2_report = h2_report + h2_string + "\n\n1. LENGTH: \n\t\t- " + h2_char_count + " characters\n\t\t- or, " + h2_twords + " keywords & " + h2_tws + " whitespace(s).";
                    h2_report = h2_report + "\n\n2. h2 KEYWORDS:";
                    for (i = 0; i < h2_twords; ++i) {
                        h2_report = h2_report + "\n\t\t- " + h2_total_a[i];
                    }


                }
                //group of all h3 tags
                if (h3_bool == true) {


                    Elements h3Tags = hTags.select("h3");
                    int i = 0;
                    for (Element h3Tag : h3Tags) {
                        i = i + 1;
                        h3_string = h3_string + "\n\t" + i + ". " + h3Tag.text();
                        h3_string_ftc = h3_string_ftc + h3Tag.text();
                    }
                    //fetch the h3_char_count, h3_word_count, h3_ws_count
                    char[] ch_array_h3 = h3_string_ftc.toCharArray();
                    h3_char_count = h3_string_ftc.length();

                    //white space count for h3
                    for (int o = 0; o < h3_char_count; ++o) {
                        if (ch_array_h3[o] == ' ') {
                            h3_tws += 1;
                        }
                    }
                    //words count for h3
                    if (ch_array_h3[0] == ' ') {

                        if (ch_array_h3[h3_char_count - 1] == ' ') {
                            if (h3_tws == 2) {

                                h3_twords = 1;
                            }
                            if (h3_tws > 2) {
                                h3_twords = h3_tws - 1;
                            }
                        } else {
                            if (h3_tws == 1) {
                                h3_twords = 1;
                            }
                            if (h3_tws > 1) {
                                h3_twords = h3_tws;
                            }
                        }
                    } else {
                        if (ch_array_h3[h3_char_count - 1] == ' ') {
                            if (h3_tws == 1) {
                                h3_twords = 1;
                            }
                            if (h3_tws > 1) {
                                h3_twords = h3_tws;
                            }
                        } else {
                            if (h3_tws == 0) {
                                h3_twords = 1;
                            }
                            if (h3_tws > 0) {
                                h3_twords = h3_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h3[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h3_char_count) {
                        if (ch_array_h3[key_pos] != ' ') {
                            h3_total_a[i] += ch_array_h3[key_pos];
                        } else {
                            h3_total_a[i] += ch_array_h3[key_pos];
                            i = i + 1;
                            if ((i - 1) == h3_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h3 report
                    h3_report = "";
                    h3_report += "h3 Summary:\n\n" + "There are " + h3_size + " h3 headers. Each of them are provided below.";
                    h3_report = h3_report + h3_string + "\n\n1. LENGTH: \n\t\t- " + h3_char_count + " characters\n\t\t- or, " + h3_twords + " keywords & " + h3_tws + " whitespace(s).";
                    h3_report = h3_report + "\n\n2. h3 KEYWORDS:";
                    for (i = 0; i < h3_twords; ++i) {
                        h3_report = h3_report + "\n\t\t- " + h3_total_a[i];
                    }


                }
                //group of all h4 tags
                if (h4_bool == true) {

                    Elements h4Tags = hTags.select("h4");
                    int i = 0;
                    for (Element h4Tag : h4Tags) {
                        i = i + 1;
                        h4_string = h4_string + "\n\t" + i + ". " + h4Tag.text();
                        h4_string_ftc = h4_string_ftc + h4Tag.text();
                    }
                    //fetch the h4_char_count, h4_word_count, h4_ws_count
                    char[] ch_array_h4 = h4_string_ftc.toCharArray();
                    h4_char_count = h4_string_ftc.length();

                    //white space count for h4
                    for (int o = 0; o < h4_char_count; ++o) {
                        if (ch_array_h4[o] == ' ') {
                            h4_tws += 1;
                        }
                    }
                    //words count for h4
                    if (ch_array_h4[0] == ' ') {

                        if (ch_array_h4[h4_char_count - 1] == ' ') {
                            if (h4_tws == 2) {

                                h4_twords = 1;
                            }
                            if (h4_tws > 2) {
                                h4_twords = h4_tws - 1;
                            }
                        } else {
                            if (h4_tws == 1) {
                                h4_twords = 1;
                            }
                            if (h4_tws > 1) {
                                h4_twords = h4_tws;
                            }
                        }
                    } else {
                        if (ch_array_h4[h4_char_count - 1] == ' ') {
                            if (h4_tws == 1) {
                                h4_twords = 1;
                            }
                            if (h4_tws > 1) {
                                h4_twords = h4_tws;
                            }
                        } else {
                            if (h4_tws == 0) {
                                h4_twords = 1;
                            }
                            if (h4_tws > 0) {
                                h4_twords = h4_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h4[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h4_char_count) {
                        if (ch_array_h4[key_pos] != ' ') {
                            h4_total_a[i] += ch_array_h4[key_pos];
                        } else {
                            h4_total_a[i] += ch_array_h4[key_pos];
                            i = i + 1;
                            if ((i - 1) == h4_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h4 report
                    h4_report = "";
                    h4_report += "h4 Summary:\n\n" + "There are " + h4_size + " h4 headers. Each of them are provided below.";
                    h4_report = h4_report + h4_string + "\n\n1. LENGTH: \n\t\t- " + h4_char_count + " characters\n\t\t- or, " + h4_twords + " keywords & " + h4_tws + " whitespace(s).";
                    h4_report = h4_report + "\n\n2. h4 KEYWORDS:";
                    for (i = 0; i < h4_twords; ++i) {
                        h4_report = h4_report + "\n\t\t- " + h4_total_a[i];
                    }


                }
                //group of all h5 tags
                if (h5_bool == true) {


                    Elements h5Tags = hTags.select("h5");
                    int i = 0;
                    for (Element h5Tag : h5Tags) {
                        i = i + 1;
                        h5_string = h5_string + "\n\t" + i + ". " + h5Tag.text();
                        h5_string_ftc = h5_string_ftc + h5Tag.text();
                    }
                    //fetch the h5_char_count, h5_word_count, h5_ws_count
                    char[] ch_array_h5 = h5_string_ftc.toCharArray();
                    h5_char_count = h5_string_ftc.length();

                    //white space count for h5
                    for (int o = 0; o < h5_char_count; ++o) {
                        if (ch_array_h5[o] == ' ') {
                            h5_tws += 1;
                        }
                    }
                    //words count for h5
                    if (ch_array_h5[0] == ' ') {

                        if (ch_array_h5[h5_char_count - 1] == ' ') {
                            if (h5_tws == 2) {

                                h5_twords = 1;
                            }
                            if (h5_tws > 2) {
                                h5_twords = h5_tws - 1;
                            }
                        } else {
                            if (h5_tws == 1) {
                                h5_twords = 1;
                            }
                            if (h5_tws > 1) {
                                h5_twords = h5_tws;
                            }
                        }
                    } else {
                        if (ch_array_h5[h5_char_count - 1] == ' ') {
                            if (h5_tws == 1) {
                                h5_twords = 1;
                            }
                            if (h5_tws > 1) {
                                h5_twords = h5_tws;
                            }
                        } else {
                            if (h5_tws == 0) {
                                h5_twords = 1;
                            }
                            if (h5_tws > 0) {
                                h5_twords = h5_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h5[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h5_char_count) {
                        if (ch_array_h5[key_pos] != ' ') {
                            h5_total_a[i] += ch_array_h5[key_pos];
                        } else {
                            h5_total_a[i] += ch_array_h5[key_pos];
                            i = i + 1;
                            if ((i - 1) == h5_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h5 report
                    h5_report = "";
                    h5_report += "h5 Summary:\n\n" + "There are " + h5_size + " h5 headers. Each of them are provided below.";
                    h5_report = h5_report + h5_string + "\n\n1. LENGTH: \n\t\t- " + h5_char_count + " characters\n\t\t- or, " + h5_twords + " keywords & " + h5_tws + " whitespace(s).";
                    h5_report = h5_report + "\n\n2. h5 KEYWORDS:";
                    for (i = 0; i < h5_twords; ++i) {
                        h5_report = h5_report + "\n\t\t- " + h5_total_a[i];
                    }


                }
                //group of all h6 tags
                if (h6_bool == true) {

                    Elements h6Tags = hTags.select("h6");
                    int i = 0;
                    for (Element h6Tag : h6Tags) {
                        i = i + 1;
                        h6_string = h6_string + "\n\t" + i + ". " + h6Tag.text();
                        h6_string_ftc = h6_string_ftc + h6Tag.text();
                    }
                    //fetch the h6_char_count, h6_word_count, h6_ws_count
                    char[] ch_array_h6 = h6_string_ftc.toCharArray();
                    h6_char_count = h6_string_ftc.length();

                    //white space count for h6
                    for (int o = 0; o < h6_char_count; ++o) {
                        if (ch_array_h6[o] == ' ') {
                            h6_tws += 1;
                        }
                    }
                    //words count for h6
                    if (ch_array_h6[0] == ' ') {

                        if (ch_array_h6[h6_char_count - 1] == ' ') {
                            if (h6_tws == 2) {

                                h6_twords = 1;
                            }
                            if (h6_tws > 2) {
                                h6_twords = h6_tws - 1;
                            }
                        } else {
                            if (h6_tws == 1) {
                                h6_twords = 1;
                            }
                            if (h6_tws > 1) {
                                h6_twords = h6_tws;
                            }
                        }
                    } else {
                        if (ch_array_h6[h6_char_count - 1] == ' ') {
                            if (h6_tws == 1) {
                                h6_twords = 1;
                            }
                            if (h6_tws > 1) {
                                h6_twords = h6_tws;
                            }
                        } else {
                            if (h6_tws == 0) {
                                h6_twords = 1;
                            }
                            if (h6_tws > 0) {
                                h6_twords = h6_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h6[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h6_char_count) {
                        if (ch_array_h6[key_pos] != ' ') {
                            h6_total_a[i] += ch_array_h6[key_pos];
                        } else {
                            h6_total_a[i] += ch_array_h6[key_pos];
                            i = i + 1;
                            if ((i - 1) == h6_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h6 report
                    h6_report = "";
                    h6_report += "h6 Summary:\n\n" + "There are " + h6_size + " h6 headers. Each of them are provided below.";
                    h6_report = h6_report + h6_string + "\n\n1. LENGTH: \n\t\t- " + h6_char_count + " characters\n\t\t- or, " + h6_twords + " keywords & " + h6_tws + " whitespace(s).";
                    h6_report = h6_report + "\n\n2. h6 KEYWORDS:\n";
                    for (i = 0; i < h6_twords; ++i) {
                        h6_report = h6_report + "\n\t\t- " + h6_total_a[i];
                    }


                }

                headers_report_h1_h6 = "";
                //headers report


                headers_report_h1_h6 = "Available Headers from h1 to h6:";
                if (h1_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h1 tag is available";
                }
                if (h2_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h2 tag is available";
                }
                if (h3_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h3 tag is available";
                }
                if (h4_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h4 tag is available";
                }
                if (h5_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h5 tag is available";
                }
                if (h6_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h6 tag is available";
                }
                int total_h1_h6_words = h1_twords + h2_twords + h3_twords + h4_twords + h5_twords + h6_twords;
                headers_report_h1_h6 = headers_report_h1_h6 + "\n\nTotal Keywords Contributed \nfrom Headers <h1> to <h6> is: " + total_h1_h6_words + " keywords";

                if (h1_bool == true) {
                    headers_report_h1_h6 += "\n\n\n---------------------------------------------------------------------------------------------\n" + h1_report;
                }
                if (h2_bool == true) {
                    headers_report_h1_h6 += "\n---------------------------------------------------------------------------------------------\n\n" + h2_report;
                }
                if (h3_bool == true) {
                    headers_report_h1_h6 += "\n---------------------------------------------------------------------------------------------\n\n" + h3_report;
                }
                if (h4_bool == true) {
                    headers_report_h1_h6 += "\n---------------------------------------------------------------------------------------------\n\n" + h4_report;
                }
                if (h5_bool == true) {
                    headers_report_h1_h6 += "\n---------------------------------------------------------------------------------------------\n\n" + h5_report;
                }
                if (h6_bool == true) {
                    headers_report_h1_h6 += "\n---------------------------------------------------------------------------------------------\n\n" + h6_report;
                }

            }

//BODY Tag
            if (url_valid_on_bool == true) {
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                p_tags_size = document.getElementsByTag("p").size();
                div_tags_size = document.getElementsByTag("div").size();
                h1_tags_size = document.getElementsByTag("h1").size();
                h2_tags_size = document.getElementsByTag("h2").size();
                h3_tags_size = document.getElementsByTag("h3").size();
                h4_tags_size = document.getElementsByTag("h4").size();
                h5_tags_size = document.getElementsByTag("h5").size();
                h6_tags_size = document.getElementsByTag("h6").size();
                img_tags_size = document.getElementsByTag("img").size();
                href_tags_size = document.select("a[href]").size();
                meta_description_tags_size = document.select("meta[name=description]").size();
                meta_keywords_size = document.select("meta[name=keywords]").size();
                meta_robots_size = document.select("meta[name=robot]").size();
                meta_view_port_size = document.select("meta[name=viewport]").size();
                link_rel_canonical_tag_size = document.select("link[rel=canonical]").size();
                meta_author_size = document.select("meta[name=author]").size();


//                meta_keywords_string = String.valueOf(document.attr("name:keywords"));
//                meta_description_string = document.attr("name:description");
//                meta_viewport_string = document.attr("name:viewport");
//                meta_robots_string = document.attr("name:robots");
//                rel_canonical_report_string=document.attr("name:canonical");
//                meta_author_string=document.attr("name:author");

                meta__tags_total = document.select("meta").size();

                p_tags_bool = false;
                div_tags_bool = false;
                h1_tags_bool = false;
                h2_tags_bool = false;
                h3_tags_bool = false;
                h4_tags_bool = false;
                h5_tags_bool = false;
                h6_tags_bool = false;
                img_tags_bool = false;
                href_tags_bool = false;
                meta_description_tags_bool = false;
                meta_keywords_bool = false;
                meta_robots_bool = false;
                meta_view_port_bool = false;
                link_rel_canonical_tag_bool = false;
                meta_author_bool = false;


                if (p_tags_size > 0)
                    p_tags_bool = true;
                if (div_tags_size > 0)
                    div_tags_bool = true;
                if (h1_tags_size > 0)
                    h1_tags_bool = true;
                if (h2_tags_size > 0)
                    h2_tags_bool = true;
                if (h3_tags_size > 0)
                    h3_tags_bool = true;
                if (h4_tags_size > 0)
                    h4_tags_bool = true;
                if (h5_tags_size > 0)
                    h5_tags_bool = true;
                if (h6_tags_size > 0)
                    h6_tags_bool = true;
                if (img_tags_size > 0)
                    img_tags_bool = true;
                if (href_tags_size > 0)
                    href_tags_bool = true;
                if (meta_description_tags_size > 0)
                    meta_description_tags_bool = true;
                if (meta_keywords_size > 0)
                    meta_keywords_bool = true;
                if (meta_robots_size > 0)
                    meta_robots_bool = true;
                if (meta_view_port_size > 0)
                    meta_view_port_bool = true;
                if (link_rel_canonical_tag_size > 0)
                    link_rel_canonical_tag_bool = true;
                if (meta_author_size > 0)
                    meta_author_bool = true;


                body_report = "";
                body_report = "The Site's Body Element Has ..\n";

                if (p_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + p_tags_size + " <p> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + p_tags_size + " <p> tag(s).";

                if (div_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + div_tags_size + " <div> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + div_tags_size + " <div> tag(s).";

                if (h1_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h1_tags_size + " <h1> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h1_tags_size + " <h1> tag(s).";


                if (h2_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h2_tags_size + " <h2> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h2_tags_size + " <h2> tag(s).";

                if (h3_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h3_tags_size + " <h3> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h3_tags_size + " <h3> tag(s).";

                if (h4_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h4_tags_size + " <h4> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h4_tags_size + " <h4> tag(s).";

                if (h5_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h5_tags_size + " <h5> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h5_tags_size + " <h5> tag(s).";

                if (h6_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h6_tags_size + " <h6> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h6_tags_size + " <h6> tag(s).";

                if (img_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + img_tags_size + " <img> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + img_tags_size + " <img> tag(s).";

                if (href_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + href_tags_size + " <a href> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + href_tags_size + " <a href> tag(s).";

                if (meta__tags_total > 0) {
                    body_report = body_report + "\n\n\n\t- TOTAL META Tags Available: " + meta__tags_total + " <meta> tag(s).";
                } else {
                    body_report = body_report + "\n\n\n\t- TOTAL META Tags Available: " + meta__tags_total + " <meta> tag.";
                }

                if (meta_description_tags_size > 0)
                    body_report = body_report + "\n\n\n\t\t- " + meta_description_tags_size + " meta description tag.";
                else
                    body_report = body_report + "\n\t\t- " + meta_description_tags_size + " meta description tag.";

                if (meta_keywords_size > 0)
                    body_report = body_report + "\n\t\t- " + meta_keywords_size + " meta keyword tag.";
                else
                    body_report = body_report + "\n\t\t- " + meta_keywords_size + " meta keyword tag.";

                if (meta_robots_size > 0)
                    body_report = body_report + "\n\t\t- " + meta_robots_size + " meta robots tag.";
                else
                    body_report = body_report + "\n\t\t- " + meta_robots_size + " meta robots tag.";

                if (meta_view_port_size > 0)
                    body_report = body_report + "\n\t\t- " + meta_view_port_size + " meta View port tag.";
                else
                    body_report = body_report + "\n\t\t- " + meta_view_port_size + " meta View port tag.";

                if (meta_author_size > 0)
                    body_report = body_report + "\n\t\t- " + meta_author_size + " meta Author tag.";
                else
                    body_report = body_report + "\n\t\t- " + meta_author_size + " meta Author tag.";


                if (link_rel_canonical_tag_size > 0)
                    body_report = body_report + "\n\t\t- " + link_rel_canonical_tag_size + " Link rel canonical tag.";
                else
                    body_report = body_report + "\n\t\t- " + link_rel_canonical_tag_size + " Link rel canonical tag.";
            }

//LINKS Tag
            if (url_valid_on_bool == true) {
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);

                Elements links = document.select("a[href]");
                int i = 0;

                highlightedLink_str_a[0] = "";
                highlightedLink_str_a[1] = "";
                highlightedLink_str_a[2] = "";
                highlightedLink_str_a[3] = "";
                highlightedLink_str_a[4] = "";
                highlightedLink_str_a[5] = "";
                highlightedLink_str_a[6] = "";
                highlightedLink_str_a[7] = "";
                highlightedLink_str_a[8] = "";
                highlightedLink_str_a[9] = "";
                highlightedLink_str_a[10] = "";
                highlightedLink_str_a[11] = "";
                highlightedLink_str_a[12] = "";
                highlightedLink_str_a[13] = "";
                highlightedLink_str_a[14] = "";
                highlightedLink_str_a[15] = "";
                highlightedLink_str_a[16] = "";
                highlightedLink_str_a[17] = "";
                highlightedLink_str_a[18] = "";
                highlightedLink_str_a[19] = "";
                highlightedLink_str_a[20] = "";
                highlightedLink_str_a[21] = "";
                highlightedLink_str_a[22] = "";
                highlightedLink_str_a[23] = "";
                highlightedLink_str_a[24] = "";
                highlightedLink_str_a[25] = "";
                highlightedLink_str_a[26] = "";
                highlightedLink_str_a[27] = "";
                highlightedLink_str_a[28] = "";
                highlightedLink_str_a[29] = "";
                highlightedLink_str_a[30] = "";
                highlightedLink_str_a[31] = "";
                highlightedLink_str_a[32] = "";
                highlightedLink_str_a[33] = "";
                highlightedLink_str_a[34] = "";
                highlightedLink_str_a[35] = "";
                highlightedLink_str_a[36] = "";
                highlightedLink_str_a[37] = "";
                highlightedLink_str_a[38] = "";
                highlightedLink_str_a[39] = "";
                highlightedLink_str_a[40] = "";
                highlightedLink_str_a[41] = "";
                highlightedLink_str_a[42] = "";
                highlightedLink_str_a[43] = "";
                highlightedLink_str_a[44] = "";
                highlightedLink_str_a[45] = "";
                highlightedLink_str_a[46] = "";
                highlightedLink_str_a[47] = "";
                highlightedLink_str_a[48] = "";
                highlightedLink_str_a[49] = "";
                highlightedLink_str_a[50] = "";
                highlightedLink_str_a[51] = "";
                highlightedLink_str_a[52] = "";
                highlightedLink_str_a[53] = "";
                highlightedLink_str_a[54] = "";
                highlightedLink_str_a[55] = "";
                highlightedLink_str_a[56] = "";
                highlightedLink_str_a[57] = "";
                highlightedLink_str_a[58] = "";
                highlightedLink_str_a[59] = "";
                highlightedLink_str_a[60] = "";

                highlightedLink_str_a[61] = "";
                highlighted_text_str_a[61] = "";
                highlightedLink_str_a[62] = "";
                highlighted_text_str_a[62] = "";
                highlightedLink_str_a[63] = "";
                highlighted_text_str_a[63] = "";
                highlightedLink_str_a[64] = "";
                highlighted_text_str_a[64] = "";
                highlightedLink_str_a[65] = "";
                highlighted_text_str_a[65] = "";
                highlightedLink_str_a[66] = "";
                highlighted_text_str_a[66] = "";
                highlightedLink_str_a[67] = "";
                highlighted_text_str_a[67] = "";
                highlightedLink_str_a[68] = "";
                highlighted_text_str_a[68] = "";
                highlightedLink_str_a[69] = "";
                highlighted_text_str_a[69] = "";
                highlightedLink_str_a[70] = "";
                highlighted_text_str_a[70] = "";
                highlightedLink_str_a[71] = "";
                highlighted_text_str_a[71] = "";
                highlightedLink_str_a[72] = "";
                highlighted_text_str_a[72] = "";
                highlightedLink_str_a[73] = "";
                highlighted_text_str_a[73] = "";
                highlightedLink_str_a[74] = "";
                highlighted_text_str_a[74] = "";
                highlightedLink_str_a[75] = "";
                highlighted_text_str_a[75] = "";
                highlightedLink_str_a[76] = "";
                highlighted_text_str_a[76] = "";
                highlightedLink_str_a[77] = "";
                highlighted_text_str_a[77] = "";
                highlightedLink_str_a[78] = "";
                highlighted_text_str_a[78] = "";
                highlightedLink_str_a[79] = "";
                highlighted_text_str_a[79] = "";
                highlightedLink_str_a[80] = "";
                highlighted_text_str_a[80] = "";
                highlightedLink_str_a[81] = "";
                highlighted_text_str_a[81] = "";
                highlightedLink_str_a[82] = "";
                highlighted_text_str_a[82] = "";
                highlightedLink_str_a[83] = "";
                highlighted_text_str_a[83] = "";
                highlightedLink_str_a[84] = "";
                highlighted_text_str_a[84] = "";
                highlightedLink_str_a[85] = "";
                highlighted_text_str_a[85] = "";
                highlightedLink_str_a[86] = "";
                highlighted_text_str_a[86] = "";
                highlightedLink_str_a[87] = "";
                highlighted_text_str_a[87] = "";
                highlightedLink_str_a[88] = "";
                highlighted_text_str_a[88] = "";
                highlightedLink_str_a[89] = "";
                highlighted_text_str_a[89] = "";
                highlightedLink_str_a[90] = "";
                highlighted_text_str_a[90] = "";
                highlightedLink_str_a[91] = "";
                highlighted_text_str_a[91] = "";
                highlightedLink_str_a[92] = "";
                highlighted_text_str_a[92] = "";
                highlightedLink_str_a[93] = "";
                highlighted_text_str_a[93] = "";
                highlightedLink_str_a[94] = "";
                highlighted_text_str_a[94] = "";
                highlightedLink_str_a[95] = "";
                highlighted_text_str_a[95] = "";
                highlightedLink_str_a[96] = "";
                highlighted_text_str_a[96] = "";
                highlightedLink_str_a[97] = "";
                highlighted_text_str_a[97] = "";
                highlightedLink_str_a[98] = "";
                highlighted_text_str_a[98] = "";
                highlightedLink_str_a[99] = "";
                highlighted_text_str_a[99] = "";
                highlightedLink_str_a[100] = "";
                highlighted_text_str_a[100] = "";
                highlightedLink_str_a[101] = "";
                highlighted_text_str_a[101] = "";
                highlightedLink_str_a[102] = "";
                highlighted_text_str_a[102] = "";
                highlightedLink_str_a[103] = "";
                highlighted_text_str_a[103] = "";
                highlightedLink_str_a[104] = "";
                highlighted_text_str_a[104] = "";
                highlightedLink_str_a[105] = "";
                highlighted_text_str_a[105] = "";
                highlightedLink_str_a[106] = "";
                highlighted_text_str_a[106] = "";
                highlightedLink_str_a[107] = "";
                highlighted_text_str_a[107] = "";
                highlightedLink_str_a[108] = "";
                highlighted_text_str_a[108] = "";
                highlightedLink_str_a[109] = "";
                highlighted_text_str_a[109] = "";
                highlightedLink_str_a[110] = "";
                highlighted_text_str_a[110] = "";
                highlightedLink_str_a[111] = "";
                highlighted_text_str_a[111] = "";
                highlightedLink_str_a[112] = "";
                highlighted_text_str_a[112] = "";
                highlightedLink_str_a[113] = "";
                highlighted_text_str_a[113] = "";
                highlightedLink_str_a[114] = "";
                highlighted_text_str_a[114] = "";
                highlightedLink_str_a[115] = "";
                highlighted_text_str_a[115] = "";
                highlightedLink_str_a[116] = "";
                highlighted_text_str_a[116] = "";
                highlightedLink_str_a[117] = "";
                highlighted_text_str_a[117] = "";
                highlightedLink_str_a[118] = "";
                highlighted_text_str_a[118] = "";
                highlightedLink_str_a[119] = "";
                highlighted_text_str_a[119] = "";
                highlightedLink_str_a[120] = "";
                highlighted_text_str_a[120] = "";
                highlightedLink_str_a[121] = "";
                highlighted_text_str_a[121] = "";
                highlightedLink_str_a[122] = "";
                highlighted_text_str_a[122] = "";
                highlightedLink_str_a[123] = "";
                highlighted_text_str_a[123] = "";
                highlightedLink_str_a[124] = "";
                highlighted_text_str_a[124] = "";
                highlightedLink_str_a[125] = "";
                highlighted_text_str_a[125] = "";
                highlightedLink_str_a[126] = "";
                highlighted_text_str_a[126] = "";
                highlightedLink_str_a[127] = "";
                highlighted_text_str_a[127] = "";
                highlightedLink_str_a[128] = "";
                highlighted_text_str_a[128] = "";
                highlightedLink_str_a[129] = "";
                highlighted_text_str_a[129] = "";
                highlightedLink_str_a[130] = "";
                highlighted_text_str_a[130] = "";
                highlightedLink_str_a[131] = "";
                highlighted_text_str_a[131] = "";
                highlightedLink_str_a[132] = "";
                highlighted_text_str_a[132] = "";
                highlightedLink_str_a[133] = "";
                highlighted_text_str_a[133] = "";
                highlightedLink_str_a[134] = "";
                highlighted_text_str_a[134] = "";
                highlightedLink_str_a[135] = "";
                highlighted_text_str_a[135] = "";
                highlightedLink_str_a[136] = "";
                highlighted_text_str_a[136] = "";
                highlightedLink_str_a[137] = "";
                highlighted_text_str_a[137] = "";
                highlightedLink_str_a[138] = "";
                highlighted_text_str_a[138] = "";
                highlightedLink_str_a[139] = "";
                highlighted_text_str_a[139] = "";
                highlightedLink_str_a[140] = "";
                highlighted_text_str_a[140] = "";
                highlightedLink_str_a[141] = "";
                highlighted_text_str_a[141] = "";
                highlightedLink_str_a[142] = "";
                highlighted_text_str_a[142] = "";
                highlightedLink_str_a[143] = "";
                highlighted_text_str_a[143] = "";
                highlightedLink_str_a[144] = "";
                highlighted_text_str_a[144] = "";
                highlightedLink_str_a[145] = "";
                highlighted_text_str_a[145] = "";
                highlightedLink_str_a[146] = "";
                highlighted_text_str_a[146] = "";
                highlightedLink_str_a[147] = "";
                highlighted_text_str_a[147] = "";
                highlightedLink_str_a[148] = "";
                highlighted_text_str_a[148] = "";
                highlightedLink_str_a[149] = "";
                highlighted_text_str_a[149] = "";
                highlightedLink_str_a[150] = "";
                highlighted_text_str_a[150] = "";
                highlightedLink_str_a[151] = "";
                highlighted_text_str_a[151] = "";
                highlightedLink_str_a[152] = "";
                highlighted_text_str_a[152] = "";
                highlightedLink_str_a[153] = "";
                highlighted_text_str_a[153] = "";
                highlightedLink_str_a[154] = "";
                highlighted_text_str_a[154] = "";
                highlightedLink_str_a[155] = "";
                highlighted_text_str_a[155] = "";
                highlightedLink_str_a[156] = "";
                highlighted_text_str_a[156] = "";
                highlightedLink_str_a[157] = "";
                highlighted_text_str_a[157] = "";
                highlightedLink_str_a[158] = "";
                highlighted_text_str_a[158] = "";
                highlightedLink_str_a[159] = "";
                highlighted_text_str_a[159] = "";
                highlightedLink_str_a[160] = "";
                highlighted_text_str_a[160] = "";
                highlightedLink_str_a[161] = "";
                highlighted_text_str_a[161] = "";
                highlightedLink_str_a[162] = "";
                highlighted_text_str_a[162] = "";
                highlightedLink_str_a[163] = "";
                highlighted_text_str_a[163] = "";
                highlightedLink_str_a[164] = "";
                highlighted_text_str_a[164] = "";
                highlightedLink_str_a[165] = "";
                highlighted_text_str_a[165] = "";
                highlightedLink_str_a[166] = "";
                highlighted_text_str_a[166] = "";
                highlightedLink_str_a[167] = "";
                highlighted_text_str_a[167] = "";
                highlightedLink_str_a[168] = "";
                highlighted_text_str_a[168] = "";
                highlightedLink_str_a[169] = "";
                highlighted_text_str_a[169] = "";
                highlightedLink_str_a[170] = "";
                highlighted_text_str_a[170] = "";

                highlighted_text_str_a[0] = "";
                highlighted_text_str_a[1] = "";
                highlighted_text_str_a[2] = "";
                highlighted_text_str_a[3] = "";
                highlighted_text_str_a[4] = "";
                highlighted_text_str_a[5] = "";
                highlighted_text_str_a[6] = "";
                highlighted_text_str_a[7] = "";
                highlighted_text_str_a[8] = "";
                highlighted_text_str_a[9] = "";
                highlighted_text_str_a[10] = "";
                highlighted_text_str_a[11] = "";
                highlighted_text_str_a[12] = "";
                highlighted_text_str_a[13] = "";
                highlighted_text_str_a[14] = "";
                highlighted_text_str_a[15] = "";
                highlighted_text_str_a[16] = "";
                highlighted_text_str_a[17] = "";
                highlighted_text_str_a[18] = "";
                highlighted_text_str_a[19] = "";
                highlighted_text_str_a[20] = "";
                highlighted_text_str_a[21] = "";
                highlighted_text_str_a[22] = "";
                highlighted_text_str_a[23] = "";
                highlighted_text_str_a[24] = "";
                highlighted_text_str_a[25] = "";
                highlighted_text_str_a[26] = "";
                highlighted_text_str_a[27] = "";
                highlighted_text_str_a[28] = "";
                highlighted_text_str_a[29] = "";
                highlighted_text_str_a[30] = "";
                highlighted_text_str_a[31] = "";
                highlighted_text_str_a[32] = "";
                highlighted_text_str_a[33] = "";
                highlighted_text_str_a[34] = "";
                highlighted_text_str_a[35] = "";
                highlighted_text_str_a[36] = "";
                highlighted_text_str_a[37] = "";
                highlighted_text_str_a[38] = "";
                highlighted_text_str_a[39] = "";
                highlighted_text_str_a[40] = "";
                highlighted_text_str_a[41] = "";
                highlighted_text_str_a[42] = "";
                highlighted_text_str_a[43] = "";
                highlighted_text_str_a[44] = "";
                highlighted_text_str_a[45] = "";
                highlighted_text_str_a[46] = "";
                highlighted_text_str_a[47] = "";
                highlighted_text_str_a[48] = "";
                highlighted_text_str_a[49] = "";
                highlighted_text_str_a[50] = "";
                highlighted_text_str_a[51] = "";
                highlighted_text_str_a[52] = "";
                highlighted_text_str_a[53] = "";
                highlighted_text_str_a[54] = "";
                highlighted_text_str_a[55] = "";
                highlighted_text_str_a[56] = "";
                highlighted_text_str_a[57] = "";
                highlighted_text_str_a[58] = "";
                highlighted_text_str_a[59] = "";
                highlighted_text_str_a[60] = "";

                for (Element link : links) {
                    i += 1;
                    highlightedLink_str_a[i] += link.attr("abs:href");
                    highlighted_text_str_a[i] += link.text().trim();
                }

                links_count = i;


                href_strings_report = "-------------------------------------------------------------------------------------------\n";
                href_strings_report = "TOTAL Internal Links(href tags) with Highighted Texts available counts to: " + i + " / " + link_text_count_size_numbers + " in numbers.\n\nNOTE: The Following List is Provided in a \"Highlighted Text and the Link\" way. Any disappearance in one of these twos means that the website developer(s) have not provided the same in purpose. .. ";
                href_strings_report += "\n\n-------------------------------------------------------------------------------------------\n\n";
                for (int j = 0; j < i; ++j) {
                    href_strings_report = href_strings_report + "\n\t\t- \"" + highlighted_text_str_a[j] + "\"";
                    href_strings_report = href_strings_report + "\n\t\t- " + highlightedLink_str_a[j];
                    href_strings_report = href_strings_report + "\n";
                }


            }

//IMAGES Tag
            if (url_valid_on_bool == true) {
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
                img_linksrc_value[0] = "";
                img_linksrc_value[1] = "";
                img_linksrc_value[2] = "";
                img_linksrc_value[3] = "";
                img_linksrc_value[4] = "";
                img_linksrc_value[5] = "";
                img_linksrc_value[6] = "";
                img_linksrc_value[7] = "";
                img_linksrc_value[8] = "";
                img_linksrc_value[9] = "";
                img_linksrc_value[10] = "";
                img_linksrc_value[11] = "";
                img_linksrc_value[12] = "";
                img_linksrc_value[13] = "";
                img_linksrc_value[14] = "";
                img_linksrc_value[15] = "";
                img_linksrc_value[16] = "";
                img_linksrc_value[17] = "";
                img_linksrc_value[18] = "";
                img_linksrc_value[19] = "";
                img_linksrc_value[20] = "";
                img_linksrc_value[21] = "";
                img_linksrc_value[22] = "";
                img_linksrc_value[23] = "";
                img_linksrc_value[24] = "";
                img_linksrc_value[25] = "";
                img_linksrc_value[26] = "";
                img_linksrc_value[27] = "";
                img_linksrc_value[28] = "";
                img_linksrc_value[29] = "";
                img_linksrc_value[30] = "";
                img_linksrc_value[31] = "";
                img_linksrc_value[32] = "";
                img_linksrc_value[33] = "";
                img_linksrc_value[34] = "";
                img_linksrc_value[35] = "";
                img_linksrc_value[36] = "";
                img_linksrc_value[37] = "";
                img_linksrc_value[38] = "";
                img_linksrc_value[39] = "";
                img_linksrc_value[40] = "";
                img_linksrc_value[41] = "";
                img_linksrc_value[42] = "";
                img_linksrc_value[43] = "";
                img_linksrc_value[44] = "";
                img_linksrc_value[45] = "";
                img_linksrc_value[46] = "";
                img_linksrc_value[47] = "";
                img_linksrc_value[48] = "";
                img_linksrc_value[49] = "";
                img_linksrc_value[50] = "";
                img_linksrc_value[51] = "";
                img_linksrc_value[52] = "";
                img_linksrc_value[53] = "";
                img_linksrc_value[54] = "";
                img_linksrc_value[55] = "";
                img_linksrc_value[56] = "";
                img_linksrc_value[57] = "";
                img_linksrc_value[58] = "";
                img_linksrc_value[59] = "";
                img_linksrc_value[60] = "";

                img_res_value[0] = "";
                img_res_value[1] = "";
                img_res_value[2] = "";
                img_res_value[3] = "";
                img_res_value[4] = "";
                img_res_value[5] = "";
                img_res_value[6] = "";
                img_res_value[7] = "";
                img_res_value[8] = "";
                img_res_value[9] = "";
                img_res_value[10] = "";
                img_res_value[11] = "";
                img_res_value[12] = "";
                img_res_value[13] = "";
                img_res_value[14] = "";
                img_res_value[15] = "";
                img_res_value[16] = "";
                img_res_value[17] = "";
                img_res_value[18] = "";
                img_res_value[19] = "";
                img_res_value[20] = "";
                img_res_value[21] = "";
                img_res_value[22] = "";
                img_res_value[23] = "";
                img_res_value[24] = "";
                img_res_value[25] = "";
                img_res_value[26] = "";
                img_res_value[27] = "";
                img_res_value[28] = "";
                img_res_value[29] = "";
                img_res_value[30] = "";
                img_res_value[31] = "";
                img_res_value[32] = "";
                img_res_value[33] = "";
                img_res_value[34] = "";
                img_res_value[35] = "";
                img_res_value[36] = "";
                img_res_value[37] = "";
                img_res_value[38] = "";
                img_res_value[39] = "";
                img_res_value[40] = "";
                img_res_value[41] = "";
                img_res_value[42] = "";
                img_res_value[43] = "";
                img_res_value[44] = "";
                img_res_value[45] = "";
                img_res_value[46] = "";
                img_res_value[47] = "";
                img_res_value[48] = "";
                img_res_value[49] = "";
                img_res_value[50] = "";
                img_res_value[51] = "";
                img_res_value[52] = "";
                img_res_value[53] = "";
                img_res_value[54] = "";
                img_res_value[55] = "";
                img_res_value[56] = "";
                img_res_value[57] = "";
                img_res_value[58] = "";
                img_res_value[59] = "";
                img_res_value[60] = "";

                img_alt_value[0] = "";
                img_alt_value[1] = "";
                img_alt_value[2] = "";
                img_alt_value[3] = "";
                img_alt_value[4] = "";
                img_alt_value[5] = "";
                img_alt_value[6] = "";
                img_alt_value[7] = "";
                img_alt_value[8] = "";
                img_alt_value[9] = "";
                img_alt_value[10] = "";
                img_alt_value[11] = "";
                img_alt_value[12] = "";
                img_alt_value[13] = "";
                img_alt_value[14] = "";
                img_alt_value[15] = "";
                img_alt_value[16] = "";
                img_alt_value[17] = "";
                img_alt_value[18] = "";
                img_alt_value[19] = "";
                img_alt_value[20] = "";
                img_alt_value[21] = "";
                img_alt_value[22] = "";
                img_alt_value[23] = "";
                img_alt_value[24] = "";
                img_alt_value[25] = "";
                img_alt_value[26] = "";
                img_alt_value[27] = "";
                img_alt_value[28] = "";
                img_alt_value[29] = "";
                img_alt_value[30] = "";
                img_alt_value[31] = "";
                img_alt_value[32] = "";
                img_alt_value[33] = "";
                img_alt_value[34] = "";
                img_alt_value[35] = "";
                img_alt_value[36] = "";
                img_alt_value[37] = "";
                img_alt_value[38] = "";
                img_alt_value[39] = "";
                img_alt_value[40] = "";
                img_alt_value[41] = "";
                img_alt_value[42] = "";
                img_alt_value[43] = "";
                img_alt_value[44] = "";
                img_alt_value[45] = "";
                img_alt_value[46] = "";
                img_alt_value[47] = "";
                img_alt_value[48] = "";
                img_alt_value[49] = "";
                img_alt_value[50] = "";
                img_alt_value[51] = "";
                img_alt_value[52] = "";
                img_alt_value[53] = "";
                img_alt_value[54] = "";
                img_alt_value[55] = "";
                img_alt_value[56] = "";
                img_alt_value[57] = "";
                img_alt_value[58] = "";
                img_alt_value[59] = "";
                img_alt_value[60] = "";

                img_count_size = document.getElementsByTag("img").size();


                //iterate images and print image attributes
                int i = 0;
                img_alt_count_size = 0;
                for (Element image : images) {
                    i += 1;
                    img_linksrc_value[i] = image.attr("src");
                    img_res_value[i] = image.attr("width") + " x " + image.attr("height");
                    img_alt_value[i] = image.attr("alt");
                    if (img_alt_value[i] != "") {
                        img_alt_bool[i] = true;
                        img_alt_count_size += 1;
                    } else {
                        img_alt_bool[i] = false;
                    }
                }

                //images Report
                //Any images present?
                //5 images are present
                //The image along with their Alt Values are as

                //image src
                //image resolution
                //image alt value present?
                //img alt value


                //Images Report Starts Now!
                if (img_count_size < 1) {
                    img_report_string = "No Images Are present in this Site !";
                } else {
                    img_report_string = "Images(or, <img> tag(s)) are present in this Site.\n";
                    img_report_string += "\n" + img_count_size + " images are available..\nOut of which " + (img_alt_count_size - 1) + " of them has provided Alt values.\n";
                    img_report_string += "\n\n\nThe images along with their src, size/resolution in pixels & Alt Values are as Follows.\n\n\n\n---------------------------------------------------------------------------------------------\n ";

                    for (int k = 0; k < i; ++k) {
                        img_report_string += "\n\t\t- SRC: " + img_linksrc_value[k];
                        img_report_string += "\n\t\t- RESOLUTION: " + img_res_value[k];
                        img_report_string += "\n\t\t- ALT Available(?): " + img_alt_bool[k];
                        if (img_alt_bool[k] == true) {
                            img_report_string += "\n\t\t- ALT value : " + img_alt_value[k] + "\n\t\t--------------------------------------------------------------\n";
                        } else {
                            img_report_string += "\n\t\t--------------------------------------------------------------\n";
                        }

                    }
                }


            }

//KEYWORDS Tag
            if (url_valid_on_bool == true) {



                total_keywords_count = img_alt_count_size + links_count + h1_twords + h2_twords + h3_twords + h4_twords + h5_twords + h6_twords + title_word_count;

                keywords_report = "The site contains at least " + total_keywords_count + " Keywords in total.\nThe keywords are as follows: \n\n\n";
                int ws_keywords_count = 0;

                if (title_word_count > 0) {
                    for (int i = 0; i < title_word_count; i = i + 3) {
                        if (title_keywords_a[i] == " ")
                            ws_keywords_count += 1;

                        keywords_report += "\n\t\t- " + title_keywords_a[i] + " , " + title_keywords_a[i + 1] + " , " + title_keywords_a[i + 2];
                    }
                    keywords_report += "\n";
                }
                if (links_count > 0) {
                    for (int i = 0; i < links_count; ++i) {
                        if (highlighted_text_str_a[i] == " ")
                            ws_keywords_count += 1;

                        keywords_report += "\n\t\t- " + highlighted_text_str_a[i] + " , " + highlighted_text_str_a[i + 1] + " , " + highlighted_text_str_a[i + 2];
                    }
                    keywords_report += "\n";
                }
                if (img_alt_count_size > 0) {
                    for (int i = 0; i < img_alt_count_size; ++i) {
                        if (img_alt_value[i] == " ")
                            ws_keywords_count += 1;

                        keywords_report += "\n\t\t- " + img_alt_value[i] + " , " + img_alt_value[i + 1] + " , " + img_alt_value[i + 2];
                    }
                    keywords_report += "\n";
                }
                if (h1_twords > 0) {
                    for (int i = 0; i < h1_twords; ++i) {
                        if (h1_total_a[i] == " ")
                            ws_keywords_count += 1;

                        keywords_report += "\n\t\t- " + h1_total_a[i] + " , " + h1_total_a[i + 1] + " , " + h1_total_a[i + 2];
                    }
                    keywords_report += "\n";
                }
                if (h2_twords > 0) {
                    for (int i = 0; i < h2_twords; ++i) {
                        if (h2_total_a[i] == " ")
                            ws_keywords_count += 1;

                        keywords_report += "\n\t\t- " + h2_total_a[i] + " , " + h2_total_a[i + 1] + " , " + h2_total_a[i + 2];
                    }
                    keywords_report += "\n";
                }
                if (h3_twords > 0) {
                    for (int i = 0; i < h3_twords; ++i) {
                        if (h3_total_a[i] == " ")
                            ws_keywords_count += 1;

                        keywords_report += "\n\t\t- " + h3_total_a[i] + " , " + h3_total_a[i + 1] + " , " + h3_total_a[i + 2];
                    }
                    keywords_report += "\n";
                }
                if (h4_twords > 0) {
                    for (int i = 0; i < h4_twords; ++i) {
                        if (h4_total_a[i] == " ")
                            ws_keywords_count += 1;
                        keywords_report += "\n\t\t- " + h4_total_a[i] + " , " + h4_total_a[i + 1] + " , " + h4_total_a[i + 2];
                    }
                    keywords_report += "\n";
                }
                if (h5_twords > 0) {
                    for (int i = 0; i < h5_twords; ++i) {
                        if (h5_total_a[i] == " ")
                            ws_keywords_count += 1;
                        keywords_report += "\n\t\t- " + h5_total_a[i] + " , " + h5_total_a[i + 1] + " , " + h5_total_a[i + 2];
                    }
                    keywords_report += "\n";
                }
                if (h6_twords > 0) {
                    for (int i = 0; i < h6_twords; ++i) {
                        if (h6_total_a[i] == " ")
                            ws_keywords_count += 1;
                        keywords_report += "\n\t\t- " + h6_total_a[i] + " , " + h6_total_a[i + 1] + " , " + h6_total_a[i + 2];
                    }
                    keywords_report += "\n";
                }
                keywords_report += "\n---------------------------------------------------------------------------------------------\nThe site has used " + ws_keywords_count + " whitespaces in place of keywords unnecessarily. ..";
//Meta meta_keywords_string, meta_author_string, meta_description_string, meta_viewport_string, rel_canonical      presents
                if (url_valid_on_bool == true) {
                    org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                    Elements metaTags = document.getElementsByTag("meta");

                    for (Element metaTag : metaTags) {
                        String content = metaTag.attr("content");
                        String name = metaTag.attr("name");

                        meta_description_tags_size = document.select("meta[name~=(description|Description)]").size();
                        meta_keywords_size = document.select("meta[name~=(keywords|Keywords)]").size();
                        meta_robots_size = document.select("meta[name~=(robots|Robots)]").size();
                        meta_view_port_size = document.select("meta[name~=(viewport|Viewport)]").size();
                        link_rel_canonical_tag_size = document.select("link[rel~=(canonical|Canonical)]").size();
                        meta_author_size = document.select("meta[name~=(author|Author)]").size();

                        if (meta_robots_size > 0) {
                            meta_robots_bool = true;
                        }
                        if (meta_description_tags_size > 0) {
                            meta_description_tags_bool = true;
                        }
                        if (meta_keywords_size > 0) {
                            meta_keywords_bool = true;
                        }
                        if (meta_view_port_size > 0) {
                            meta_view_port_bool = true;
                        }
                        if (link_rel_canonical_tag_size > 0) {
                            link_rel_canonical_tag_bool = true;
                        }
                        if (meta_author_size > 0) {
                            meta_author_bool = true;
                        }


                        if ("description".equals(name)) {
                            meta_description_string = content;

                        }
                        if ("Description".equals(name)) {
                            meta_description_string = content;
                        }

                        if ("keywords".equals(name)) {
                            meta_keywords_string = content;
                        }
                        if ("Keywords".equals(name)) {
                            meta_keywords_string = content;
                        }

                        if ("author".equals(name)) {
                            meta_author_string = content;
                        }
                        if ("Author".equals(name)) {
                            meta_author_string = content;
                        }

                        if ("viewport".equals(name)) {
                            meta_viewport_string = content;
                        }
                        if ("Viewport".equals(name)) {
                            meta_viewport_string = content;
                        }

                        if ("robots".equals(name)) {
                            meta_robots_string = content;
                        }
                        if ("Robots".equals(name)) {
                            meta_robots_string = content;
                        }

                    }
                    Elements links = document.getElementsByTag("link");
                    for (Element link : links) {
                        String content = link.attr("href");
                        String name = link.attr("rel");

                        if ("Canonical".equals(name)) {
                            rel_canonical_report_string = content;
                        }
                        if ("canonical".equals(name)) {
                            rel_canonical_report_string = content;
                        }
                    }

                    if (link_rel_canonical_tag_bool) {
                        rel_canonical_report = "link rel=\"canonical\" tag exists.\nVALUE: " + rel_canonical_report_string;
                    } else {
                        rel_canonical_report = "link rel=\"canonical\" tag doesn't Exist !";
                    }
                    if (meta_description_tags_bool == true) {
                        meta_description_report = "Meta Description Exists; \n" + "VALUE: " + meta_description_string;
                    } else {
                        meta_description_report = "Meta Description doesn't Exist !";
                    }
                    if (meta_keywords_bool == true) {
                        meta_keywords_report = "Meta Keywords Exists; \n" + "VALUE: " + meta_keywords_string;
                    } else {
                        meta_keywords_report = "Meta Keywords doesn't Exist !";
                    }
                    if (meta_author_bool == true) {
                        meta_author_report = "Meta Author Exists; \n" + "VALUE: " + meta_author_string;
                    } else {
                        meta_author_report = "Meta Author doesn't Exist !";
                    }
                    if (meta_robots_bool == true) {
                        meta_robots_report = "Meta Robots Exists; \n" + "VALUE: " + meta_robots_string;
                    } else {
                        meta_robots_report = "Meta Robots doesn't Exist !";
                    }
                    if (meta_view_port_bool == true) {
                        meta_viewport_report = "Meta View Port Exists; \n" + "VALUE: " + meta_viewport_string;
                    } else {
                        meta_viewport_report = "Meta View Port doesn't Exist !";
                    }
                }
//Page Favicon
                int favicon_Size = 0;
                if (url_valid_on_bool == true) {
                    org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                    Element element = document.head().select("link[href~=.*\\.(ico|png)]").first();
                    page_favicon_report = " ";
                    try {
                        page_favicon_report = element.attr("href");
                    } catch (NullPointerException e) {
                        page_favicon_report = e.toString();
                    }
                    favicon_Size = document.select("link[name=icon]").size();
                    if (favicon_Size > 0) {
                        page_favicon_report = "Page Favicon Exists &\nLINK: " + page_favicon_report;
                    } else {
                        page_favicon_report = "PAge Favicon Doesn't Exist !";
                    }
                }
//            Toast.makeText(getApplicationContext(), "Please Wait !", Toast.LENGTH_LONG).show();

            }return null;
        }
        @Override
        protected void onPostExecute(Void result){
            mProgressDialog.hide();
//                Toast.makeText(getApplicationContext(), "Ready to Display !", Toast.LENGTH_LONG).show();
            if(url_valid_bool_real!=true){
                Toast.makeText(getApplicationContext(), "URL Invalid", Toast.LENGTH_SHORT).show();
            }

            textView_on_no_report_page.setVisibility(View.GONE);
            full_report_website_SEO.setVisibility(View.VISIBLE);

            tvBody1.setText(surl_report);
            tvBody2.setText(html_string);
            tvBody3.setText(title_report);
            tvBody4.setText(headers_report_h1_h6);
            tvBody5.setText(body_report);
            tvBody6.setText(href_strings_report);
            tvBody7.setText(img_report_string);
            tvBody8.setText(keywords_report);
            tvBody9.setText(page_favicon_report);
            tvBody14.setText(meta_description_report);
            tvBody15.setText(meta_robots_report);
            tvBody16.setText(meta_viewport_report);
            tvBody17.setText(rel_canonical_report);
            tvBody18.setText(meta_author_report);
            tvBody19.setText(meta_keywords_report);



        }
    }


}