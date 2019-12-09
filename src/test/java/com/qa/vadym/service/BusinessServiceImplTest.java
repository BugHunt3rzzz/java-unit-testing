package com.qa.vadym.service;

import com.google.common.collect.Lists;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BusinessServiceImplTest {
    private static final String FIRST_SPRING = "Spring is a Java framework";
    private static final String SECOND_SPRING = "Everybody likes Spring";
    private static final String THIRD_SPRING = "During Spring we often go fishing";
    private static final String FOURTH_NOT_SPRING = "Sprin Gsprin Sprint String";

    @InjectMocks
    private BusinessServiceImpl businessServiceImpl;

    @Mock
    private ProcessService processService;

    @Captor
    private ArgumentCaptor<String> captor;

    private List<String> strings = Lists.newArrayList(FIRST_SPRING, SECOND_SPRING, THIRD_SPRING, FOURTH_NOT_SPRING);


    @Test
    void retrieveTodosRelatedToSpring() {
        //given
        when(processService.ruturnTodos(anyString())).thenReturn(strings);

        //when
        List<String> resultsList = businessServiceImpl.retrieveTodosRelatedToSpring("User");

        //then
        Assertions.assertThat(resultsList)
                .containsExactly(FIRST_SPRING, SECOND_SPRING, THIRD_SPRING);
    }

    @Test
    void retrieveTodosRelatedToSpringWithNull() {
        //given
        when(processService.ruturnTodos(anyString())).thenReturn(null);

        //when
        List<String> resultsList = businessServiceImpl.retrieveTodosRelatedToSpring("User");

        //then
        Assertions.assertThat(resultsList).isEmpty();
    }

    @Test
    void deleteodosRelatedWithSpring() {
        //given
        when(processService.ruturnTodos(anyString())).thenReturn(strings);

        //when
        businessServiceImpl.deleteTodosRelatedWithSpring("User");

        //then
        verify(processService, times(1)).deleteTodos(captor.capture());

        Assertions.assertThat(captor.getValue())
                .isEqualTo(FOURTH_NOT_SPRING);
    }
}