package com.laraknife.basicdesigncompleted

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laraknife.basicdesigncompleted.ui.theme.BasicDesignCompletedTheme
import com.laraknife.basicdesigncompleted.ui.theme.Color1
import com.laraknife.basicdesigncompleted.ui.theme.Color2
import com.laraknife.basicdesigncompleted.ui.theme.Color3
import com.laraknife.basicdesigncompleted.ui.theme.Color4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicDesignCompletedTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun Home() {
    var option by rememberSaveable { mutableStateOf(0) }
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        LazyRow(
            Modifier
                .fillMaxWidth()
                .background(Color4)) {
            item {
                Button(onClick = { option = 0 }, Modifier.padding(top = 24.dp, bottom = 24.dp, start = 8.dp, end = 8.dp)) {
                    Text(text = "Colab 1", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
                Button(onClick = { option = 1 }, Modifier.padding(top = 24.dp, bottom = 24.dp, start = 8.dp, end = 8.dp)) {
                    Text(text = "Colab 2", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
                Button(onClick = { option = 2 }, Modifier.padding(top = 24.dp, bottom = 24.dp, start = 8.dp, end = 8.dp)) {
                    Text(text = "Colab 3.1", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
                Button(onClick = { option = 3 }, Modifier.padding(top = 24.dp, bottom = 24.dp, start = 8.dp, end = 8.dp)) {
                    Text(text = "Colab 3.2", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
                Button(onClick = { option = 4 }, Modifier.padding(top = 24.dp, bottom = 24.dp, start = 8.dp, end = 8.dp)) {
                    Text(text = "Colab 3.3", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
                Button(onClick = { option = 5 }, Modifier.padding(top = 24.dp, bottom = 24.dp, start = 8.dp, end = 8.dp)) {
                    Text(text = "Colab 4", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        Pantalla(option)
    }
}

@Composable
private fun Pantalla(option: Int) {
    when (option) {
        0 -> {
            GreetingText(message = "Happy Birthday Edgar!", from ="From Lara")
        }
        1 -> {
            GreetingImage(
                message = stringResource(R.string.happy_birthday_text),
                from = stringResource(R.string.signature_text)
            )
        }
        2 -> {
            LlenarArticulo()
        }
        3 -> {
            TaskCompleted()
        }
        4 -> {
            Cuadrantes()
        }
        5 -> {
            TarjetaPresentacion()
        }
    }
}

@Composable
fun GreetingText(modifier: Modifier = Modifier, message: String, from: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(12.dp)
    ) {
        Text(
            text = message,
            fontSize = 80.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 100.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        )
    }
}

@Composable
private fun LlenarArticulo() {
    Articulo(
        titulo = stringResource(R.string.titulo),
        descripcion = stringResource(R.string.descripcion),
        parrafo = stringResource(R.string.parrafo),
        imagen = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
private fun Articulo(modifier: Modifier = Modifier, imagen: Painter, titulo: String, descripcion: String, parrafo: String){
    Column(modifier = modifier) {
        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = titulo,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = descripcion,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = parrafo,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
private fun TaskCompleted() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val image = painterResource(R.drawable.ic_task_completed)
        Image(painter = image, contentDescription = null)
        Text(
            text = stringResource(R.string.task_completed),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.congratulations),
            fontSize = 16.sp
        )
    }
}

@Composable
private fun Cuadrantes() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            Cuadrante(
                title = stringResource(R.string.title1),
                description = stringResource(R.string.description1),
                backgroundColor = Color1,
                modifier = Modifier.weight(1f)
            )
            Cuadrante(
                title = stringResource(R.string.title2),
                description = stringResource(R.string.description2),
                backgroundColor = Color2,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Cuadrante(
                title = stringResource(R.string.title3),
                description = stringResource(R.string.description3),
                backgroundColor = Color3,
                modifier = Modifier.weight(1f)
            )
            Cuadrante(
                title = stringResource(R.string.title4),
                description = stringResource(R.string.description4),
                backgroundColor = Color4,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun Cuadrante(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    backgroundColor: Color
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            color = Color.Black
        )
    }
}

@Composable
private fun TarjetaPresentacion() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFD2E8D4)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Profile picture",
            modifier = Modifier
                .background(Color(0xFF073143))
                .width(110.dp)
                .height(110.dp)
        )
        Text(
            text = stringResource(R.string.account_name),
            Modifier.padding(top = 4.dp),
            fontSize = 40.sp,
            color = Color.Black
        )
        Text(
            text = stringResource(R.string.puesto),
            Modifier.padding(top = 8.dp),
            color = Color(0xFF08703F),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    Icons.Default.Phone,
                    contentDescription = "Phone icon",
                    Modifier.padding(8.dp),
                    tint = Color(0xFF08703F)
                )
                Text(
                    text = stringResource(R.string.account_phone),
                    Modifier.padding(8.dp),
                    fontSize = 20.sp
                )
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    Icons.Default.Share,
                    contentDescription = "Share icon",
                    Modifier.padding(8.dp),
                    tint = Color(0xFF08703F)
                )
                Text(
                    text = stringResource(R.string.account_page),
                    Modifier.padding(8.dp),
                    fontSize = 20.sp)
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    Icons.Default.Email,
                    contentDescription = "Email icon",
                    Modifier.padding(8.dp),
                    tint = Color(0xFF08703F)
                )
                Text(
                    text = stringResource(R.string.account_email),
                    Modifier.padding(8.dp),
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomePreview() {
    BasicDesignCompletedTheme {
        Home()
    }
}