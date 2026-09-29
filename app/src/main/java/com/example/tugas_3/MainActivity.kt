package com.example.tugas_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class ItemData(
    val judul: String,
    val deskripsi: String,
    val gambar: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    DaftarScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DaftarScreen() {
    val daftar = listOf(
        ItemData("Laptop", "Komputer portabel untuk kerja, kuliah, dan coding", R.drawable.laptop),
        ItemData("Smartphone", "Ponsel pintar untuk komunikasi, kamera, dan aplikasi", R.drawable.smartphone),
        ItemData("Headphone", "Perangkat audio untuk mendengarkan musik dan meeting online", R.drawable.headphone),
        ItemData("Smartwatch", "Jam tangan pintar untuk memantau aktivitas dan notifikasi", R.drawable.smartwatch),
        ItemData("Tablet", "Layar sentuh besar untuk membaca dan mencatat", R.drawable.tablet),
        ItemData("Speaker", "Perangkat audio untuk memutar musik dengan suara keras", R.drawable.speaker),
        ItemData("Laptop Gaming", "Laptop performa tinggi untuk bermain game", R.drawable.laptopgaming),
        ItemData("Kamera", "Perangkat untuk mengambil foto dan merekam video", R.drawable.kamera),
        ItemData("Headphone Wireless", "Headphone tanpa kabel dengan noise cancelling", R.drawable.tws),
        ItemData("Mouse", "Perangkat penunjuk untuk mengontrol kursor di komputer", R.drawable.mouse),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentPadding = PaddingValues(bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        stickyHeader {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                shadowElevation = 4.dp
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "NIM: 245150407111092",
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Nama: Geatasya Alya Pramadita",
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // LIST ITEM
        items(daftar) { item ->
            ItemRow(item)
        }
    }
}

@Composable
fun ItemRow(item: ItemData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.gambar),
                contentDescription = item.judul,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = item.judul,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = item.deskripsi,
                    fontSize = 14.sp
                )
            }
        }
    }
}