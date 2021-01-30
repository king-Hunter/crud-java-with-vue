<template>
  <div class="home">
  
    <TipoProductoComponent />
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import TipoProductoComponent from '@/components/TipoProductoComponent.vue'; // @ is an alias to /src

@Component({
  components: {
    TipoProductoComponent
  },
})
export default class Home extends Vue {}
</script>
