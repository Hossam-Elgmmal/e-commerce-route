package com.route.store.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun EcomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes labelId: Int,
    @StringRes supportTextId: Int,
    trailingIconAction: () -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    @DrawableRes leadingIconId: Int? = null,
    @DrawableRes trailingIconId: Int? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isError: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        isError = isError,
        label = { Text(stringResource(labelId)) },
        supportingText = { Text(stringResource(supportTextId)) },
        leadingIcon = {
            if (leadingIconId != null) {
                Icon(
                    painter = painterResource(id = leadingIconId),
                    contentDescription = null
                )
            }
        },
        trailingIcon = {
            if (trailingIconId != null) {
                IconButton(onClick = trailingIconAction) {
                    Icon(
                        painter = painterResource(id = trailingIconId),
                        contentDescription = null
                    )
                }
            }
        },
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        modifier = modifier
    )
}