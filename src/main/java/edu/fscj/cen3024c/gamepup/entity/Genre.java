// Genre.java
// 2/13/2024
// L. Nguyen and W. Money
// POJO class to define Genre entity

package edu.fscj.cen3024c.gamepup.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "genre_id", nullable = false)
    private int genreId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genre")
    private Set<GameGenre> gameGenres;

    @Column(name = "genre_type", length = 255, nullable = false)
    private String genreType;

    @Column(name = "genre_desc", length = 255, nullable = false)
    private String genreDesc;

    public Genre() {
    }

    public Genre(Set<GameGenre> gameGenres, String genreType, String genreDes) {
        this.gameGenres = gameGenres;
        this.genreType = genreType;
        this.genreDesc = genreDes;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreType() {
        return genreType;
    }

    public void setGenreType(String genreType) {
        this.genreType = genreType;
    }

    public String getGenreDescription() {
        return genreDesc;
    }

    public void setGenreDescription(String genreDes) {
        this.genreDesc = genreDes;
    }

    public void addGameGenre(GameGenre gameGenre) {
        this.gameGenres.add(gameGenre);
        gameGenre.setGenre(this);
    }

    public void removeGameGenre(GameGenre gameGenre) {
        this.gameGenres.remove(gameGenre);
        gameGenre.setGenre(null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId, genreType, genreDesc);
    }

    @Override
    public String toString() {
        return "Genre {" +
                "genreId=" + genreId +
                ", genreType='" + genreType + '\'' +
                ", genreDes='" + genreDesc + '\'' +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Genre genre = (Genre) o;
        return genreId == genre.genreId &&
                Objects.equals(genreType, genre.genreType) &&
                Objects.equals(genreDesc, genre.genreDesc);
    }
}