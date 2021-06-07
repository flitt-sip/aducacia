<template>
  <Layout>
    <CityFilter :cities="cities" v-model:cityId="cityId" @update:cityId="onCityChange(cityId)"/>
    <Pups :pups="pups"/>
  </Layout>
</template>

<script lang="ts">
import {defineComponent} from 'vue'
import axios from "axios";

import Layout from "./components/Layout.vue"
import CityFilter from "./components/CityFilter.vue"
import Pups from "./components/Pups.vue"

export default {
  components: {
    Layout,
    CityFilter,
    Pups
  },

  data() {
    return {
      pups: [],
      cities: [],
      cityId: ""
    }
  },

  methods: {
    onCityChange(cityId: String) {
      this.fetchPups(cityId)
    },
    async fetchCities() {
      try {
        const url = `v1/city`
        const response = await axios.get(url)
        this.cities = response.data
        // results.map(post => ({
        //   title: post.title,
        //   abstract: post.abstract,
        //   url: post.url,
        //   thumbnail: this.extractImage(post).url,
        //   caption: this.extractImage(post).caption,
        //   byline: post.byline,
        //   published_date: post.published_date,
        // }))
      } catch (err) {
        if (err.response) {
          // client received an error response (5xx, 4xx)
          console.log("Server Error:", err)
        } else if (err.request) {
          // client never received a response, or request never left
          console.log("Network Error:", err)
        } else {
          console.log("Client Error:", err)
        }
      }
    },
    async fetchPups(cityId: String) {
      try {
        const url = `v1/pups/${cityId}`
        const response = await axios.get(url)
        this.pups = response.data
      } catch (err) {
        if (err.response) {
          // client received an error response (5xx, 4xx)
          console.log("Server Error:", err)
        } else if (err.request) {
          // client never received a response, or request never left
          console.log("Network Error:", err)
        } else {
          console.log("Client Error:", err)
        }
      }
    }
  },

  mounted() {
    this.fetchCities()
  },
}
</script>