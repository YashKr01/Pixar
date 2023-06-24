package com.techk.pixar.data.mappers

import com.techk.pixar.data.models.PhotoDto
import com.techk.pixar.domain.models.PhotoEntity
import java.util.UUID

class PhotoEntityMapper {

    fun toPhotoEntity(photoDto: PhotoDto): PhotoEntity {
        return PhotoEntity(
            id = photoDto.id ?: UUID.randomUUID().toString(),
            likes = photoDto.likes,
            user = photoDto.user,
            urls = photoDto.urls,
            saved = false
        )
    }

    fun toPhotoEntityList(list: List<PhotoDto>): List<PhotoEntity> {
        return list.map {
            PhotoEntity(
                id = it.id ?: UUID.randomUUID().toString(),
                likes = it.likes,
                user = it.user,
                urls = it.urls,
                saved = false
            )
        }
    }

}