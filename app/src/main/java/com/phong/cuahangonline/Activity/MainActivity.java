package com.phong.cuahangonline.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.phong.cuahangonline.Adapter.LoaispAdapter;
import com.phong.cuahangonline.Adapter.SanphamAdapter;
import com.phong.cuahangonline.Model.LoaiSP;
import com.phong.cuahangonline.Model.SanPham;
import com.phong.cuahangonline.R;
import com.phong.cuahangonline.Util.CheckConnection;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;                // thanh phia tren
    private ViewFlipper viewFlipper;        // quang cao
    private RecyclerView recyclerView;
    private NavigationView navigationView;  // ban le ben trai
    private DrawerLayout drawerLayout;     // lay out chinh cua mh
    private List<LoaiSP> loaiSPList;
    private List<SanPham> sanPhamList;
    private SanphamAdapter sanphamAdapter;
    private LoaispAdapter loaispAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        AcctionItemNavigate();
        setAdapterNewsanpham();
        getDulieuNewsanpham();
        Acctionbar();
        AcctionviewFlipper();

    }

    private void AcctionItemNavigate() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_dienthoai:{
                        break;
                    }
                    case R.id.item_laptop:{
                        break;
                    }
                    case R.id.item_dangnhap:{
                        Intent intent = new Intent(getApplicationContext(), ActivityFacebookLogin.class);
                        startActivityForResult(intent, 123);
                        break;
                    }
                    case R.id.item_caidat:{
                        break;
                    }
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void getDulieuNewsanpham() {
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("sanpham").orderBy("id", Query.Direction.DESCENDING)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot snapshot : task.getResult()) {
                                long id = (long) snapshot.get("id");
                                String tensanpham = (String) snapshot.get("tensanpham");
                                long giasanpham = (long) snapshot.get("giasanpham");
                                String hinhanhsanpham = (String) snapshot.get("hinhanhsanpham");
                                String motasp = (String) snapshot.get("motasanpham");
                                long idsanpham = (long) snapshot.get("idsanpham");
                                SanPham sp = new SanPham(id, tensanpham, giasanpham, hinhanhsanpham, motasp, idsanpham);
                                sanPhamList.add(sp);
                            }
                            sanphamAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("faild tag app", "onFailure: " + e.toString());
                    }
                });

    }

    private void setAdapterNewsanpham() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(sanphamAdapter);
    }

    private void AcctionviewFlipper() {
        List<String> list = Arrays.asList("https://cdn.tgdd.vn/qcao/03_01_2019_16_53_28_Nokia81-800-300.png",
                "https://cdn.tgdd.vn/qcao/31_12_2018_11_18_12_Big-oppo-800-300.png",
                "https://cdn.tgdd.vn/Files/2019/01/03/1142392/nokia81-26_800x450.jpg");
        for (String s : list) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(s).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animationSlideIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animationSlideOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animationSlideIn);
        viewFlipper.setOutAnimation(animationSlideOut);
    }

    private void Acctionbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar_manhinhchinh);
        viewFlipper = findViewById(R.id.viewflipper_manhinhchinh);
        recyclerView = findViewById(R.id.recyclerview_manhinhchinh);
        navigationView = findViewById(R.id.navigation_manhinhchinh);
        drawerLayout = findViewById(R.id.drawLayout_manhinhchinh);
        loaiSPList = new ArrayList<>();
        sanPhamList = new ArrayList<>();
        loaispAdapter = new LoaispAdapter(loaiSPList, getApplicationContext());
        sanphamAdapter = new SanphamAdapter(sanPhamList, getApplicationContext());
    }



}
