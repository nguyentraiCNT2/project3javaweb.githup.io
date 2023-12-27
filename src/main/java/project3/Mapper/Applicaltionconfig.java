package project3.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import project3.Mapper.Opject.*;
import project3.entity.ImportProductsEntity;

@Configuration
public class Applicaltionconfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public UserTokenMapper userTokenMapper(ModelMapper modelMapper){
return new UserTokenMapper(modelMapper );
    }
    @Bean
    public UserMapper userMapper(ModelMapper modelMapper){
        return new UserMapper(modelMapper );
    }
    @Bean
    public UserAddressMapper userAddressMapper(ModelMapper modelMapper){
        return new UserAddressMapper(modelMapper );
    }
    @Bean
    public ShoppingCartMapper shoppingCartMapper(ModelMapper modelMapper){
        return new ShoppingCartMapper(modelMapper );
    }
    @Bean
    public Shipmapper shipmapper(ModelMapper modelMapper){
        return new Shipmapper(modelMapper );
    }
    @Bean
    public RoleMapper roleMapper(ModelMapper modelMapper){
        return new RoleMapper(modelMapper );
    }
    @Bean
    public ReveiwMapper reveiwMapper(ModelMapper modelMapper){
        return new ReveiwMapper(modelMapper );
    }
    @Bean
    public Productsmapper productsmapper(ModelMapper modelMapper){
        return new Productsmapper(modelMapper );
    }
    @Bean
    public OrderMapper orderMapper(ModelMapper modelMapper){
        return new OrderMapper(modelMapper );
    }
    @Bean
    public OrderdetailsMapper orderdetailsMapper(ModelMapper modelMapper){
        return new OrderdetailsMapper(modelMapper );
    }
    @Bean
    public LoveListMapper loveListMapper(ModelMapper modelMapper){
        return new LoveListMapper(modelMapper );
    }
    @Bean
    public ImagesMapper imagesMapper(ModelMapper modelMapper){
        return new ImagesMapper(modelMapper );
    }
    @Bean
    public CustomersMapper customersMapper(ModelMapper modelMapper){
        return new CustomersMapper(modelMapper );
    }
    @Bean
    public ColorMappper colorMappper(ModelMapper modelMapper){
        return new ColorMappper(modelMapper );
    }
    @Bean
    public CategoryMapper categoryMapper(ModelMapper modelMapper){
        return new CategoryMapper(modelMapper );
    }
    @Bean
    public CategoryLV2Mapper categoryLV2Mapper(ModelMapper modelMapper){
        return new CategoryLV2Mapper(modelMapper );
    }
    @Bean
    public ImportdetailsMapper importdetailsMapper(ModelMapper modelMapper){
        return new ImportdetailsMapper(modelMapper );
    }
    @Bean
    public ImportProductsMapper importProductsMapper(ModelMapper modelMapper){
        return new ImportProductsMapper(modelMapper );
    }

    @Bean
    public NewsMapper newsMapper(ModelMapper modelMapper){
        return new NewsMapper(modelMapper );
    }
    @Bean
    public BlackListMapper blackListMapper(ModelMapper modelMapper){
        return new BlackListMapper(modelMapper );
    }
}
