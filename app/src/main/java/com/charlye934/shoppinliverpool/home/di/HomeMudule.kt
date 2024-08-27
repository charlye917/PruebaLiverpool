package com.charlye934.shoppinliverpool.home.di

import com.charlye934.shoppinliverpool.home.data.repository.HomeRepository
import com.charlye934.shoppinliverpool.home.data.repository.HomeRepositoryImp
import com.charlye934.shoppinliverpool.home.presenter.viewmodel.dataproducts.DataProductsViewModelDelegate
import com.charlye934.shoppinliverpool.home.presenter.viewmodel.dataproducts.DataProductsViewModelDelegateImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {

    @Binds
    abstract fun homeRepositoryModule(homeRepositoryImp: HomeRepositoryImp): HomeRepository

    @Binds
    abstract fun dataProductsViewModelDelegate(dataProductsViewModelDelegateImp: DataProductsViewModelDelegateImp): DataProductsViewModelDelegate
}