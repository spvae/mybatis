package mvnTest.lombok;


import lombok.*;

public class PojoTest {
    public static void main(String[] args) {
        GetSetTest test = new GetSetTest(2,"test");

        System.out.println(test.getId()); // 2
        System.out.println(test.getName()); // test


    }
}

@ToString(callSuper = true,exclude = "id")
@EqualsAndHashCode(callSuper = false,exclude = {"name"})
@RequiredArgsConstructor()
class GetSetTest{
    @Getter @Setter private int id ;
    @Getter @Setter private String name ;
    public GetSetTest(int id,String name){
        this.id = id ;
        this.name = name;
    }

}
