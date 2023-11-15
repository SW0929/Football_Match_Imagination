package server.kickoff.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import server.kickoff.domain.Member;

import javax.sql.DataSource;
import java.util.Optional;

@Slf4j
@Repository
public class JdbcTemplateMemberRepository implements MemberRepository{

    private final NamedParameterJdbcTemplate template;
    private final SimpleJdbcInsert jdbcInsert;

    @Autowired
    public JdbcTemplateMemberRepository(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("member")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Member save(Member member) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(member);
        Number key = jdbcInsert.executeAndReturnKey(param);
        member.setId(key.longValue());
        return member;
    }

    @Override
    public void update(Long memberId, MemberUpdateDto memberParam) {

    }

    @Override
    public Optional<Member> findById(Long id) {
        String sql = "select id, user_id, password, user_name, gender, age, phone_number, position, create_date from member where id = :id";
        try {
            SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
            Member member = template.queryForObject(sql, param, MemberRowMapper());
            return Optional.of(member);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Member> findByLoginIdAndPassword(String userId, String password) {
        String sql = "select id, user_id, password, user_name, gender, age, phone_number, position, create_date from member where user_id = :user_id and passwor = :password";
        try {
            SqlParameterSource param = new MapSqlParameterSource().addValue("user_id", userId).addValue("password", password);
            Member member = template.queryForObject(sql, param, MemberRowMapper());
            return Optional.of(member);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private RowMapper<Member> MemberRowMapper() {
       return BeanPropertyRowMapper.newInstance(Member.class);
    }
}
