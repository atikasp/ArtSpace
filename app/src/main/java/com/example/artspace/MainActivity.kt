package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()) {  ArtSpaceApp()  }
            }
        }
    }
}

@Composable
fun ArtScreen(
    painting:Int,
    title: Int,
    artist: Int,
    contentDescText: Int,
    modifier: Modifier = Modifier,
    onPrevClick: () ->Unit,
    onNextClick: () ->Unit
) {
    Column (
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .safeDrawingPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Surface(
            shadowElevation = 20.dp,
            color = Color.White,
            shape = RoundedCornerShape(20.dp),
            border= BorderStroke(1.dp, Color.LightGray),
            modifier = modifier.weight(2f))
        {
            Image(
                painter = painterResource(painting),
                contentDescription = stringResource(contentDescText),
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

        }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                //.weight(1f)
                .padding(top = 30.dp)
                .background(Color.LightGray)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(title),
                fontSize = 20.sp,
                modifier = modifier.padding(start = 8.dp, top = 12.dp, end = 8.dp)
                )
            Text(text = stringResource(artist),
                fontSize = 14.sp,
                modifier = modifier.padding(start = 8.dp, bottom = 12.dp, end = 8.dp)
                )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(top = 32.dp, bottom = 16.dp)
                .fillMaxWidth()
            )
        {
            Button(
                modifier = modifier.weight(1f),
                onClick = onPrevClick)
            {
                Text(stringResource(R.string.prev))
            }
            Spacer(modifier = modifier.width(30.dp))
            Button(
                modifier = modifier.weight(1f),
                onClick = onNextClick)
            {
                Text(stringResource(R.string.next))
            }
        }
        
    }

}

@Composable
fun ArtSpaceApp(){
    var listImage by remember { mutableIntStateOf(1) }
    when(listImage){
        1 -> ArtScreen(
                painting =R.drawable.study_for_a_portrait_of_a_woman__1670s_,
                title = R.string.study_for_a_portrait_of_a_woman_1670s,
                artist = R.string.sir_peter_lely_dutch_1618_1680,
                contentDescText = R.string.study_for_a_portrait_of_a_woman_1670s,
                onNextClick = { listImage +=1},
                onPrevClick = { listImage =10 }
            )
        2 -> ArtScreen(
            painting = R.drawable.mercy_and_protection,
            title = R.string.mercy_and_protection_of_paupers_of_empress_elisabeth_1813,
            artist = R.string.j_zef_oleszkiewicz_polish_1777_1830,
            contentDescText = R.string.mercy_and_protection_of_paupers_of_empress_elisabeth_1813,
            onNextClick = { listImage +=1},
            onPrevClick = { listImage -=1 }
        )
        3 -> ArtScreen(
            painting = R.drawable.the_birth_of_venus,
            title = R.string.the_birth_of_venus,
            artist = R.string.adolf_hir_my_hirschl_hungarian_1860_1933,
            contentDescText = R.string.the_birth_of_venus,
            onNextClick = { listImage +=1},
            onPrevClick = { listImage -=1 }
        )
        4 -> ArtScreen(
            painting =R.drawable.wounded_amazon__1905_,
            title = R.string.wounded_amazon_1905,
            artist = R.string.franz_von_stuck_german_1863_1928,
            contentDescText = R.string.wounded_amazon_1905,
            onNextClick = { listImage +=1},
            onPrevClick = { listImage -=1 }
        )
        5 -> ArtScreen(
            painting =R.drawable.beautiful_anthia_leads_her_companion,
            title = R.string.beautiful_anthia_leads_her_companions_to_the_temple_of_diana_in_ephesus,
            artist = R.string.joseph_paelinck_belgian_1781_1839,
            contentDescText = R.string.beautiful_anthia_leads_her_companions_to_the_temple_of_diana_in_ephesus,
            onNextClick = { listImage +=1},
            onPrevClick = { listImage -=1 }
        )
        6 -> ArtScreen(
            painting =R.drawable.jupiter_and_antiope,
            title = R.string.jupiter_and_antiope,
            artist = R.string.luca_giordano_italian_1634_1705,
            contentDescText = R.string.jupiter_and_antiope,
            onNextClick = { listImage +=1},
            onPrevClick = { listImage -=1 }
        )
        7 -> ArtScreen(
            painting =R.drawable.the_birth_of_venus,
            title = R.string.the_birth_of_venus_after_boucher_c_1750_1770,
            artist = R.string.jacques_charlier_french_1720_1790,
            contentDescText = R.string.the_birth_of_venus,
            onNextClick = { listImage +=1},
            onPrevClick = { listImage -=1 }
        )
        8 -> ArtScreen(
            painting =R.drawable.artemis,
            title = R.string.artemis_1893_1894,
            artist = R.string.vilhelm_hammersh_i_danish_1864_1916,
            contentDescText = R.string.artemis_1893_1894,
            onNextClick = { listImage +=1},
            onPrevClick = { listImage -=1 }
        )
        9 -> ArtScreen(
            painting =R.drawable.athena_and_odysseus__1750__,
            title = R.string.athena_and_odysseus_1750,
            artist = R.string.rienk_keyert_dutch_1709_1775,
            contentDescText = R.string.athena_and_odysseus_1750,
            onNextClick = { listImage +=1},
            onPrevClick = { listImage -=1 }
        )
        10 -> ArtScreen(
            painting =R.drawable.the_sister_of_mercy__1830___1831_,
            title = R.string.the_sister_of_mercy_1830_1831,
            artist = R.string.ary_scheffer_dutch_1795_1858,
            contentDescText = R.string.the_sister_of_mercy_1830_1831,
            onNextClick = { listImage =1},
            onPrevClick = { listImage -= 1 }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}