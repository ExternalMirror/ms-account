//package az.edu.orient.service;
//
//import az.edu.orient.entity.AccountEntity;
//import az.edu.orient.repository.AccountRepository;
//import az.edu.orient.type.Currency;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//public class AccountRepositoryFake implements AccountRepository {
//    @Override
//    public Optional<AccountEntity> findAllByUserIdAndCurrency(int userId, Currency currency) {
//        return Optional.empty();
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends AccountEntity> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends AccountEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return List.of();
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<AccountEntity> entities) {
//
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public AccountEntity getOne(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public AccountEntity getById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public AccountEntity getReferenceById(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public <S extends AccountEntity> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends AccountEntity> List<S> findAll(Example<S> example) {
//        return List.of();
//    }
//
//    @Override
//    public <S extends AccountEntity> List<S> findAll(Example<S> example, Sort sort) {
//        return List.of();
//    }
//
//    @Override
//    public <S extends AccountEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends AccountEntity> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends AccountEntity> boolean exists(Example<S> example) {
//        return false;
//    }
//
//    @Override
//    public <S extends AccountEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//        return null;
//    }
//
//    @Override
//    public <S extends AccountEntity> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends AccountEntity> List<S> saveAll(Iterable<S> entities) {
//        return List.of();
//    }
//    //this is fake for getting all by id
//    @Override
//    public Optional<AccountEntity> findById(Long aLong) {
//        AccountEntity accountEntity = new AccountEntity();
//        accountEntity.setId(aLong);
//        accountEntity.setCurrency(Currency.USD);
//        accountEntity.setIban("XXXXXXX");
//        return Optional.of(accountEntity);
//    }
//
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public List<AccountEntity> findAll() {
//        return List.of();
//    }
//
//    @Override
//    public List<AccountEntity> findAllById(Iterable<Long> longs) {
//        return List.of();
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(AccountEntity entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends AccountEntity> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public List<AccountEntity> findAll(Sort sort) {
//        return List.of();
//    }
//
//    @Override
//    public Page<AccountEntity> findAll(Pageable pageable) {
//        return null;
//    }
//}
