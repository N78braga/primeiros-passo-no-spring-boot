package N78braga.com.github.produtosApi.Repository;

import N78braga.com.github.produtosApi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    List<Produto> findByName(String name);

}
