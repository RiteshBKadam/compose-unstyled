package com.composeunstyled

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

internal val AppearInstantly: EnterTransition = fadeIn(animationSpec = tween(durationMillis = 0))
internal val DisappearInstantly: ExitTransition = fadeOut(animationSpec = tween(durationMillis = 0))
internal val NoPadding = PaddingValues(0.dp)

val LocalContentColor = compositionLocalOf { Color.Unspecified }
val LocalTextStyle = compositionLocalOf { TextStyle.Default }

internal val KeyEvent.isKeyDown: Boolean
    get() = type == KeyEventType.KeyDown

internal inline fun buildModifier(builderAction: MutableList<Modifier>.() -> Unit): Modifier {
    return buildList(builderAction).fold(Modifier as Modifier) { acc, modifier ->
        acc then modifier
    }
}