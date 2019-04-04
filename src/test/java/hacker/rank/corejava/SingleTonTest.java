package hacker.rank.corejava;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class SingleTonTest {
    
    
    @Mock
    private SingletonB b;
    
    @Test
    public void shouldCallBGetValue(){
        MockitoAnnotations.initMocks(this);
        A testObj = new A(1, b);
        when(b.getValue()).thenReturn(10);
    
        int act = testObj.aPlusB();
    
        Mockito.verify(b).getValue();
        assertThat(act).isEqualTo(11);
    }
    
    
    class A {
        private SingletonB b;
        private int value;
        
        public A(int value, SingletonB b) {
            this.value = value;
            this.b = b;
        }
        
        public int aPlusB() {
            return value + b.getValue();
        }
        
    }
    
}


