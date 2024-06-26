package com.github.lofidewanto.viodevk.client;

import elemental2.dom.HTMLButtonElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import elemental2.dom.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppEntryPointTest {

    @Mock(answer= Answers.RETURNS_DEEP_STUBS)
    private HTMLDocument document;

    @Mock(answer= Answers.RETURNS_DEEP_STUBS)
    private HTMLButtonElement button;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void addButton_created() {
        AppEntryPoint appEntryPoint = spy(AppEntryPoint.class);
        when(appEntryPoint.getDocument()).thenReturn(document);
        when(appEntryPoint.getDocument().getElementById("helloButton")).thenReturn(button);

        appEntryPoint.addButton();

        verify(button, times(1)).addEventListener(eq("click"), any());
    }
}