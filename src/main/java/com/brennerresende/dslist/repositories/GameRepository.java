package com.brennerresende.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brennerresende.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
