package com.brennerresende.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brennerresende.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
