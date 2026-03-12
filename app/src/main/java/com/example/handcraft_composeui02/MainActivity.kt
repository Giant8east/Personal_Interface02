package com.example.handcraft_composeui02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.util.fastForEach
import com.example.handcraft_composeui02.ui.theme.HandCraft_ComposeUI02Theme
import com.example.handcraft_composeui02.ui.util.px
import com.example.handcraft_composeui02.ui.util.textPx

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HandCraft_ComposeUI02Theme {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            ProfileTopBar()
        },
        containerColor = Color(0xFFF5F5F5)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UserCard()

            UserDataRow()

            TaskCard()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopBar(){
    TopAppBar(
        modifier = Modifier.padding(horizontal = 90.px()),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        )
        ,
        navigationIcon = {
            Image(
                painter = painterResource(R.mipmap.icon_back),
                contentDescription = null,
                modifier = Modifier.size(72.px())
            )
        },
        title = {
            Text(
                text = "我的",
                fontWeight = FontWeight.Bold,
                fontSize = 62.textPx(),
                modifier = Modifier.padding(start = 30.px())
            )
        },
        actions = {
            Image(
                painter = painterResource(R.mipmap.icon_notification),
                contentDescription = null,
                modifier = Modifier.size(72.px())
            )
            Spacer(Modifier.width(96.px()))
            Image(
                painter = painterResource(R.mipmap.icon_setting),
                contentDescription = null,
                modifier = Modifier.size(72.px())
            )
        }
    )
}

@Composable
fun ColumnScope.UserCard() {
    Column(
        modifier = Modifier.align(Alignment.CenterHorizontally)
            .padding(top = 109.px()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box{
            Image(
                painter = painterResource(R.mipmap.user_avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(200.px())
                    .clip(CircleShape)
                    .clickable{}
            )
            Image(
                painter = painterResource(R.mipmap.icon_camera),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(54.px())
                    .clip(CircleShape)
                    .clickable{}
            )
        }

        Text(
            text = "舒欣小姐",
            fontWeight = FontWeight.Bold,
            fontSize = 52.textPx(),
            modifier = Modifier.padding(top = 32.px())
        )

        Row(
            modifier = Modifier
                .clickable{}
                .padding(top = 12.px()),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "编辑资料",
                fontSize = 32.textPx(),
                color = Color(0xFFBCC7D0)
            )
            Icon(
                painter = painterResource(R.mipmap.icon_right),
                contentDescription = null,
                modifier = Modifier.size(32.px()),
                tint = Color(0xFFBCC7D0)
            )
        }
    }
}

data class UserData(
    val data: String,
    val label: String
)

@Composable
fun UserDataRow(){
    val datas = remember {
        listOf(
            UserData("1.6K", "访客"),
            UserData("128", "发布"),
            UserData("666", "粉丝"),
            UserData("91", "关注"),
        )
    }

    Row(
        modifier = Modifier
            .padding(horizontal = 60.px())
            .padding(top = 60.px())
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        datas.fastForEach{ data ->
            UserDataItem(data)
        }
    }
}

@Composable
fun UserDataItem(data: UserData){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = data.data,
            fontWeight = FontWeight.Bold,
            fontSize = 62.textPx()
        )
        Text(
            text = data.label,
            fontSize = 42.textPx(),
            color = Color(0xFFBCC7D0)
        )
    }
}

@Composable
fun TaskCard(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 60.px())
            .padding(top = 54.px())
    ) {
        Image(
            painter = painterResource(R.mipmap.card_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Image(
            painter = painterResource(R.mipmap.card_bg_1),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 185.px())
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .padding(horizontal = 47.px())
                .padding(bottom = 55.px()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(30.px())
        ) {
            Image(
                painter = painterResource(R.mipmap.icon_favorite),
                contentDescription = null,
                modifier = Modifier.size(140.px()),

            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "点赞一个作品",
                    fontSize = 42.textPx()
                )
                Text(
                    text = buildAnnotatedString {
                        append("积分\n")
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFFFFC700),
                                fontSize = 42.textPx()
                            )
                        ){
                            append("+15")
                        }
                    },
                    fontSize = 40.textPx(),
                    color = Color(0xFF8D9DAB)
                )
            }
            GradientButton(
                modifier = Modifier
                    .width(185.px())
                    .height(80.px())
                    .clip(CircleShape),
                onClick = {}
            ) {
                Text(
                    text = "去完成",
                    color = Color.White,
                    fontSize = 36.textPx()
                )
            }
        }
    }
}


@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    onClick:()-> Unit,
    content:@Composable ()-> Unit
){
    Box(
        modifier = modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFA2D3FF),
                        Color(0xFF379FFF)
                    )
                )
            )
            .clickable{
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}