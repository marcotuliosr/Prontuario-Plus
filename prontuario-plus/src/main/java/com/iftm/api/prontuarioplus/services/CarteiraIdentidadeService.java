import com.iftm.api.prontuarioplus.mapper.DozerMapper;
import com.iftm.api.prontuarioplus.models.CarteiraIdentidade;
import com.iftm.api.prontuarioplus.repositories.CarteiraIdentidadeRepository;
import com.iftm.api.prontuarioplus.vo.CarteiraIdentidadeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteiraIdentidadeService {

    @Autowired
    private CarteiraIdentidadeRepository repository;

    public List<CarteiraIdentidadeVO> findAll() {
        return DozerMapper.parseListObject(repository.findAll(), CarteiraIdentidadeVO.class);
    }

    public CarteiraIdentidadeVO findById(Long id) {
        return DozerMapper.parseObject(repository.findById(id).orElse(null), CarteiraIdentidadeVO.class);
    }

    public CarteiraIdentidadeVO save(CarteiraIdentidadeVO carteiraIdentidadeVO) {
        if (verifyCarteiraIdentidade(carteiraIdentidadeVO)) {
            CarteiraIdentidade carteiraIdentidade = repository.save(DozerMapper.parseObject(carteiraIdentidadeVO, CarteiraIdentidade.class));
            return DozerMapper.parseObject(carteiraIdentidade, CarteiraIdentidadeVO.class);
        }
        return null;
    }

    public CarteiraIdentidadeVO update(CarteiraIdentidadeVO carteiraIdentidadeVO) {
        CarteiraIdentidade dbCarteiraIdentidade = repository.findById(carteiraIdentidadeVO.getId()).orElse(null);
        if (dbCarteiraIdentidade != null && verifyCarteiraIdentidade(carteiraIdentidadeVO)) {
            CarteiraIdentidade carteiraIdentidade = repository.save(DozerMapper.parseObject(carteiraIdentidadeVO, CarteiraIdentidade.class));
            return DozerMapper.parseObject(carteiraIdentidade, CarteiraIdentidadeVO.class);
        }
        return null;
    }

    public String delete(Long id) {
        CarteiraIdentidade dbCarteiraIdentidade = repository.findById(id).orElse(null);
        if (dbCarteiraIdentidade != null) {
            repository.deleteById(id);
            return "CarteiraIdentidade with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    private boolean verifyCarteiraIdentidade(CarteiraIdentidadeVO carteiraIdentidadeVO) {
        // Implemente a lógica de validação da CarteiraIdentidadeVO conforme sua necessidade
        // Certifique-se de que os campos obrigatórios sejam preenchidos corretamente
        return true;
    }
}
